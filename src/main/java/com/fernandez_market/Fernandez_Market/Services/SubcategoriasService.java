package com.fernandez_market.Fernandez_Market.Services;

import com.fernandez_market.Fernandez_Market.Models.Subcategorias;
import com.fernandez_market.Fernandez_Market.Repositories.SubcategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoriasService {

    private final SubcategoriasRepository subcategoriaRepository;

    @Autowired
    public SubcategoriasService(SubcategoriasRepository subcategoriaRepository) {
        this.subcategoriaRepository = subcategoriaRepository;
    }

    public List<Subcategorias> getSubcategorias(){
        return this.subcategoriaRepository.findAll();
    }
}
