package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Marcas;
import com.fernandez_market.Fernandez_Market.Models.Promociones;
import com.fernandez_market.Fernandez_Market.Services.MarcasService;
import com.fernandez_market.Fernandez_Market.Services.PromocionesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/promocion")
public class PromocionController {

    private final PromocionesService promocionesService;

    public PromocionController(PromocionesService promocionesService) {
        this.promocionesService = promocionesService;
    }

    @GetMapping()
    public List<Promociones> getPromociones(){
        return promocionesService.getPromociones();
    }
}
