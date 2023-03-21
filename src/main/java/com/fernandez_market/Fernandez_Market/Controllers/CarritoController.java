package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @GetMapping
    public String getShoppingCartPage(Model modelo, HttpServletRequest request){
        List<Productos> productosCarrito = (List<Productos>)request.getSession().getAttribute("carritoProductos");
        BigDecimal totalPedido = new BigDecimal(0);
        BigDecimal cantidadPiezasAux = null;
        BigDecimal cantidadPiezasTotales = new BigDecimal(0);

        if (productosCarrito != null) {
            for (Productos productoAux : productosCarrito) {
                cantidadPiezasAux = new BigDecimal(productoAux.getCantidadPiezasComprar());
                totalPedido = totalPedido.add(cantidadPiezasAux.multiply(productoAux.getPrecioFinalProducto()));
                cantidadPiezasTotales = cantidadPiezasTotales.add(new BigDecimal(productoAux.getCantidadPiezasComprar()));
            }
        }

        long IdUsuarioActivo = -1;
        if (request.getSession().getAttribute("IdUsuarioActivo") != null){
            IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
        }


        modelo.addAttribute("productosCarrito", productosCarrito);
        modelo.addAttribute("totalPedido", totalPedido);
        modelo.addAttribute("cantidadPiezasTotales", cantidadPiezasTotales);


        modelo.addAttribute("IdUsuarioActivo", IdUsuarioActivo);

        return "shoppingCart";
    }
}
