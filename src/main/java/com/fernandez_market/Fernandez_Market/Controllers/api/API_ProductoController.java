package com.fernandez_market.Fernandez_Market.Controllers.api;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCardDTO;
import com.fernandez_market.Fernandez_Market.Services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/producto")
public class API_ProductoController {

    private final ProductosService productoService;

    @Autowired
    public API_ProductoController(ProductosService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Productos> getProductos(){
        return productoService.getProductos();
    }


    @GetMapping(path="/{idProducto}")
    public Productos getProductos1(@PathVariable("idProducto") long idProducto){
        return productoService.getProducto(idProducto);
    }

    @GetMapping("/getProductosMasVendidos")
    public ResponseEntity<List<ProductosCardDTO>> getRecentBooks(){

        return ResponseEntity.ok(this.productoService.getProductosMasVendidos());
    }
}
