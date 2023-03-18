package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Marcas;
import com.fernandez_market.Fernandez_Market.Services.MarcasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/marca")
public class MarcaController {

    private final MarcasService marcasService;

    public MarcaController(MarcasService marcasService) {
        this.marcasService = marcasService;
    }

    @GetMapping()
    public List<Marcas> getMarcas(){
        return marcasService.getMarcas();
    }

}
