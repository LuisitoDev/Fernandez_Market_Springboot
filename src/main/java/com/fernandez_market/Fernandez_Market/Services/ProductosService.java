package com.fernandez_market.Fernandez_Market.Services;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCardDTO;
import com.fernandez_market.Fernandez_Market.Repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<ProductosCardDTO> getProductosDeTuInteres(Long idUsuario) {
        return this.productoRepository.getProductosDeTuInteres(idUsuario, PageRequest.of(0, 12));
    }
    public List<ProductosCardDTO> getProductosMasVendidos() {
        return this.productoRepository.getProductosMasVendidos();
    }
    public List<ProductosCardDTO> getProductosNuevos() {
        return this.productoRepository.getProductosNuevos();
    }

    public List<ProductosCardDTO> getProductosBySubcategoriaNombrePagina(int id_subcategoria, String nombreProducto, int page, int quantity) {
        return this.productoRepository.getProductosBySubcategoria(id_subcategoria, nombreProducto, PageRequest.of(page  - 1, quantity));
    }

    public List<ProductosCardDTO> getProductosRelacionados(int id_subcategoria, long id_producto) {
        return this.productoRepository.getProductosRelacionados(id_subcategoria, id_producto, PageRequest.of(0, 12));
    }
}
