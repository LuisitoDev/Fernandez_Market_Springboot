package com.fernandez_market.Fernandez_Market.Services;

import com.fernandez_market.Fernandez_Market.Models.Marcas;
import com.fernandez_market.Fernandez_Market.Repositories.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcasService {

    private final MarcasRepository marcaRepository;

    @Autowired
    public MarcasService(MarcasRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marcas> getMarcas(){
        return this.marcaRepository.findAll();
    }
}
