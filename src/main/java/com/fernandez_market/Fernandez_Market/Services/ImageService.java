package com.fernandez_market.Fernandez_Market.Services;

import com.fernandez_market.Fernandez_Market.Models.*;
import com.fernandez_market.Fernandez_Market.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private CategoriasRepository categoriasRepository;
    @Autowired
    private SubcategoriasRepository subcategoriasRepository;
    @Autowired
    private MarcasRepository marcasRepository;
    @Autowired
    private ProductosRepository productosRepository;
    @Autowired
    private PromocionesRepository promocionesRepository;

    public Optional<Categorias> getRawImageCategoriaById(int id) {
        return categoriasRepository.findById(id);
    }

    public Optional<Subcategorias> getRawImageSubcategoriaById(int id) {
        return subcategoriasRepository.findById(id);
    }

    public Optional<Marcas> getRawImageMarcaById(int id) {
        return marcasRepository.findById(id);
    }

    public Optional<Productos> getRawImageProductoById(Long id) {
        return Optional.ofNullable(productosRepository.findByIdProducto(id));
    }

    public Optional<Promociones> getRawImagePromocionById(int id) {
        return promocionesRepository.findById(id);
    }

//    public int saveImage(Image image) {
//        /* this method only returns image id to optmize the process */
//        return imageRepository.save(image).getIdImage();
//    }
}
