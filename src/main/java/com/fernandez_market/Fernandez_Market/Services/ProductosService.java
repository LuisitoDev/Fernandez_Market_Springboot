package com.fernandez_market.Fernandez_Market.Services;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCard;
import com.fernandez_market.Fernandez_Market.Repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {

    private final ProductosRepository productoRepository;

    @Autowired
    public ProductosService(ProductosRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Productos> getProductos(){
        return this.productoRepository.findAll();
    }
    public Productos getProducto(long idProducto){
        try {
            return this.productoRepository.findByIdProducto(idProducto);
        } catch (Exception e) {
            // do nothing or add action code
        }

        return null;
    }

    public List<ProductosCard> getProductosMasVendidos() {
        return this.productoRepository.getProductosMasVendidos();
    }

    public List<ProductosCard> getProductosNuevos() {
        return this.productoRepository.getProductosNuevos();
    }
}
