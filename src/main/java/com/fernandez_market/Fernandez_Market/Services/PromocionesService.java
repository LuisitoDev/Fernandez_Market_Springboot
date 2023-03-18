package com.fernandez_market.Fernandez_Market.Services;

import com.fernandez_market.Fernandez_Market.Models.Promociones;
import com.fernandez_market.Fernandez_Market.Repositories.PromocionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocionesService {

    private final PromocionesRepository promocionRepository;

    @Autowired
    public PromocionesService(PromocionesRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    public List<Promociones> getPromociones(){
        return this.promocionRepository.findAll();
    }
}
