package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Pedidos;
import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Services.PedidosService;
import com.fernandez_market.Fernandez_Market.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private final UsuarioService usuarioService;
    private final PedidosService pedidosService;

    public PedidoController(UsuarioService usuarioService, PedidosService pedidosService) {
        this.usuarioService = usuarioService;
        this.pedidosService = pedidosService;
    }

    @GetMapping
    public String getPedidoPage(Model modelo, HttpServletRequest request){
        if (request.getSession().getAttribute("IdUsuarioActivo") == null) {
            modelo.addAttribute("error", "No hay un usuario loggeado");
            return "error";
        }

        Pedidos pedidoElegido = null;

        long IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
        Usuarios usuarioElegido = this.usuarioService.getUsuarioById(IdUsuarioActivo);

        if (usuarioElegido.getPedidos().size() > 0) {
            pedidoElegido = usuarioElegido.getPedidos().get(0);

            pedidoElegido.createDireccionCompleta();
        }

        request.setAttribute("pedidoElegido", pedidoElegido);

        return "pedido";
    }

    @PostMapping
    public String crearPedido(Model modelo, HttpServletRequest request,
                                    @RequestParam("Calle") String Calle, @RequestParam("N_Int") String N_Int, @RequestParam("N_Ext") String N_Ext,
                                    @RequestParam("Colonia") String Colonia, @RequestParam("Estado") String Estado, @RequestParam("Municipio") String Municipio,
                                    @RequestParam("CP") String CP, @RequestParam("Telefono") String Telefono, @RequestParam("Banco") String Banco,
                                    @RequestParam("NumCuenta") String NumCuenta
    ){
        if (request.getSession().getAttribute("IdUsuarioActivo") == null){
            modelo.addAttribute("error", "No hay un usuario registrado");
            return "error";
        }

        long idUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
        Usuarios usuario = this.usuarioService.getUsuarioById(idUsuarioActivo);

        List<Productos> productosCarrito = (List<Productos>)request.getSession().getAttribute("carritoProductos");

        BigDecimal totalPedido = new BigDecimal(0);
        BigDecimal cantidadPiezas = null;
        String Direccion =
                Calle + ", "
                        + N_Int + " - "
                        + N_Ext + ", "
                        + Colonia + ", "
                        + Municipio + ", "
                        + Estado + ", "
                        + CP;

        for(Productos productoAux : productosCarrito) {
            cantidadPiezas = new BigDecimal(productoAux.getCantidadPiezasComprar());
            totalPedido = totalPedido.add( cantidadPiezas.multiply(productoAux.getPrecioFinalProducto()) );
        }

        Pedidos pedido = new Pedidos();
        pedido.setDomicilioPedido(Direccion);
        pedido.setTelefonoClientePedido(Telefono);
        pedido.setBancoClientePedido(Banco);
        pedido.setNumCuentaClientePedido(NumCuenta);
        pedido.setPrecioTotalPedido(totalPedido);
        pedido.setUsuarioPedido(usuario);

        this.pedidosService.savePedido(pedido);

        request.getSession().setAttribute("carritoProductos", null);

        return "redirect:/perfil";
    }
}
