package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCardDTO;
import com.fernandez_market.Fernandez_Market.Services.ProductosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
    @RequestMapping("/producto")
public class ProductoController {

    private final ProductosService productosService;

    public ProductoController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping(value = {"/{id_producto}"})
    public String getProductPage(Model modelo, @PathVariable("id_producto") int id_producto) {
        Productos productoElegido = this.productosService.getProducto(id_producto);
        if(productoElegido == null) {
            modelo.addAttribute("error", "No existe el producto");
            return "error";
        }

        List<ProductosCardDTO> listaProductosRelacionados = this.productosService.getProductosRelacionados(
                productoElegido.getSubcategoriaProducto().getIdSubcategoria(),
                productoElegido.getIdProducto()
        );

        modelo.addAttribute("productoElegido", productoElegido);
        modelo.addAttribute("listaProductosRelacionados", listaProductosRelacionados);

        return "product";
    }
}
