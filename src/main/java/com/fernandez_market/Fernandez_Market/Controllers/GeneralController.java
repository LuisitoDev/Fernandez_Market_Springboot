package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Subcategorias;
import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Services.SubcategoriasService;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

public class GeneralController {

    private final SubcategoriasService subcategoriasService;

    public GeneralController(SubcategoriasService subcategoriasService) {
        this.subcategoriasService = subcategoriasService;
    }

    public static Usuarios getUsuario() {
        return null;
    }

    public static List<Subcategorias> getSubcategorias(){
        //TODO: QUITAR LO HARDCODEADO DE AQUI
        String url = "http://localhost:8080/api/subcategoria";
        RestTemplate restTemplate = new RestTemplate();
        List<Subcategorias> result = List.of(Objects.requireNonNull(restTemplate.getForObject(url, Subcategorias[].class)));

        return result;
    }
}
