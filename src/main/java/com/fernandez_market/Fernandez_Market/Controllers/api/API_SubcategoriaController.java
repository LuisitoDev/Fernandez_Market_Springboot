package com.fernandez_market.Fernandez_Market.Controllers.api;

import com.fernandez_market.Fernandez_Market.Models.Subcategorias;
import com.fernandez_market.Fernandez_Market.Services.SubcategoriasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/subcategoria")
public class API_SubcategoriaController {

    private final SubcategoriasService subcategoriasService;

    public API_SubcategoriaController(SubcategoriasService subcategoriasService) {
        this.subcategoriasService = subcategoriasService;
    }
    @GetMapping
    public  List<Subcategorias> getSubcategorias(){
        return this.subcategoriasService.getSubcategorias();
    }
}
