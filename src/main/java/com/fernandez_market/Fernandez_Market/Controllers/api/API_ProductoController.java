package com.fernandez_market.Fernandez_Market.Controllers.api;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCardDTO;
import com.fernandez_market.Fernandez_Market.Services.ProductosService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/producto")
public class API_ProductoController {

    private final ProductosService productosService;

    @Autowired
    public API_ProductoController(ProductosService productoService) {
        this.productosService = productoService;
    }

    @GetMapping
    public List<Productos> getProductos(){
        return productosService.getProductos();
    }


    @GetMapping(path="/{idProducto}")
    public Productos getProductos1(@PathVariable("idProducto") long idProducto){
        return productosService.getProducto(idProducto);
    }

    @GetMapping("/getProductosMasVendidos")
    public ResponseEntity<List<ProductosCardDTO>> getRecentBooks(){

        return ResponseEntity.ok(this.productosService.getProductosMasVendidos());
    }

    @GetMapping("/buscar/{nombreProducto}")
    public ResponseEntity<List<ProductosCardDTO>> getProductos(@PathVariable("nombreProducto") String nombreProducto){
        int numeroProducto = 1;
        short IdSubcategoriaElegida = 0;

        List<ProductosCardDTO> listaProductos = this.productosService.getProductosBySubcategoriaNombrePagina(IdSubcategoriaElegida, nombreProducto, numeroProducto, 12);

        return ResponseEntity.ok(listaProductos);
    }

    @PostMapping("/ingresar-producto")
    public ResponseEntity<String> ingresarProducto(Model modelo, HttpServletRequest request, @RequestParam("IdProducto") Long IdProducto, @RequestParam("cantidadPiezas") int cantidadPiezas){
        Productos productoElegido = this.productosService.getProducto(IdProducto);

        productoElegido.setCantidadPiezasComprar(cantidadPiezas);

        List<Productos> carritoProductos = (List<Productos>)request.getSession().getAttribute("carritoProductos");

        if (carritoProductos == null){
            carritoProductos = new ArrayList<Productos>();
        }

        boolean productoRepetido = false;
        for(int i = 0; i < carritoProductos.size(); i++) {
            if(Objects.equals(carritoProductos.get(i).getIdProducto(), productoElegido.getIdProducto())) {
                carritoProductos.get(i).setCantidadPiezasComprar(cantidadPiezas);
                productoRepetido = true;
                break;
            }
        }

        if (!productoRepetido) {
            carritoProductos.add(productoElegido);
        }

        request.getSession().setAttribute("carritoProductos", carritoProductos);

        return ResponseEntity.ok(String.valueOf(productoRepetido));
    }

    @PostMapping("/conseguir-producto")
    public ResponseEntity<Productos> conseguirProducto(Model modelo, HttpServletRequest request, @RequestParam("IdProducto") Long IdProducto){
        Productos productoElegido = this.productosService.getProducto(IdProducto);

        return ResponseEntity.ok(productoElegido);
    }

    @PostMapping("/conseguir-cantidad-stock")
    public ResponseEntity<Integer> cambiarCantidadPiezas(Model modelo, HttpServletRequest request, @RequestParam("IdProducto") Long IdProducto){
        Productos productoElegido = this.productosService.getProducto(IdProducto);

        return ResponseEntity.ok(productoElegido.getCantidadStockProducto());
    }

    @PostMapping("/cambiar-cantidad-piezas")
    public ResponseEntity<Integer> cambiarCantidadPiezas(Model modelo, HttpServletRequest request, @RequestParam("IdProducto") Long IdProducto, @RequestParam("CantidadPiezas") int CantidadPiezas){
        Productos productoElegido = this.productosService.getProducto(IdProducto);

        if (CantidadPiezas < 1)
            CantidadPiezas = 1;

        if (CantidadPiezas > productoElegido.getCantidadStockProducto())
            CantidadPiezas = productoElegido.getCantidadStockProducto();

        return ResponseEntity.ok(CantidadPiezas);
    }

    @PostMapping("/cambiar-cantidad-productos")
    public ResponseEntity<String> cambiarCantidadProductos(Model modelo, HttpServletRequest request, @RequestParam("IdProducto") Long IdProducto, @RequestParam("CantidadPiezas") int CantidadPiezas){
        Productos productoElegido = this.productosService.getProducto(IdProducto);

        if (CantidadPiezas < 1)
            CantidadPiezas = 1;
        if (CantidadPiezas > productoElegido.getCantidadStockProducto())
            CantidadPiezas = productoElegido.getCantidadStockProducto();

        List<Productos> carritoProductos = (List<Productos>)request.getSession().getAttribute("carritoProductos");

        if (carritoProductos != null) {
            for(int i = 0; i < carritoProductos.size(); i++) {
                if(Objects.equals(carritoProductos.get(i).getIdProducto(), IdProducto)) {
                    carritoProductos.get(i).setCantidadPiezasComprar(CantidadPiezas);
                    break;
                }
            }

            request.getSession().setAttribute("carritoProductos", carritoProductos);
        }

        BigDecimal precioFinal = productoElegido.getPrecioFinalProducto();
        BigDecimal cantidadPiezasBD = new BigDecimal(CantidadPiezas);
        BigDecimal precioFinalPorPiezas = precioFinal.multiply(cantidadPiezasBD);

        BigDecimal totalPedido = new BigDecimal(0);
        BigDecimal cantidadPiezasAux = null;
        BigDecimal cantidadPiezasTotales = new BigDecimal(0);

        for (Productos productoAux : carritoProductos) {
            cantidadPiezasAux = new BigDecimal(productoAux.getCantidadPiezasComprar());
            totalPedido = totalPedido.add(cantidadPiezasAux.multiply(productoAux.getPrecioFinalProducto()));
            cantidadPiezasTotales = cantidadPiezasTotales.add(new BigDecimal(productoAux.getCantidadPiezasComprar()));
        }


        return ResponseEntity.ok(CantidadPiezas + "," +precioFinalPorPiezas + "," + totalPedido + "," + cantidadPiezasTotales);
    }

    @PostMapping("/eliminar-producto-lista")
    public ResponseEntity<String> eliminarProductoLista(Model modelo, HttpServletRequest request, @RequestParam("IdProducto") Long IdProducto){
        List<Productos> carritoProductos = (List<Productos>)request.getSession().getAttribute("carritoProductos");

        if (carritoProductos != null){

            for(int i = 0; i < carritoProductos.size(); i++) {
                if(Objects.equals(carritoProductos.get(i).getIdProducto(), IdProducto)) {
                    carritoProductos.remove(i);
                    break;
                }
            }

            request.getSession().setAttribute("carritoProductos", carritoProductos);

            BigDecimal totalPedido = new BigDecimal(0);
            BigDecimal cantidadPiezas = null;
            BigDecimal cantidadPiezasTotales = new BigDecimal(0);

            for (Productos productoAux : carritoProductos) {
                cantidadPiezas = new BigDecimal(productoAux.getCantidadPiezasComprar());
                totalPedido = totalPedido.add(cantidadPiezas.multiply(productoAux.getPrecioFinalProducto()));
                cantidadPiezasTotales = cantidadPiezasTotales.add(new BigDecimal(productoAux.getCantidadPiezasComprar()));
            }


            return ResponseEntity.ok(totalPedido + "," + cantidadPiezasTotales);
        }

        return null;
    }


}
