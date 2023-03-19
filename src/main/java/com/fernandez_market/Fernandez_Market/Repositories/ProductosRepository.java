package com.fernandez_market.Fernandez_Market.Repositories;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCardDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductosRepository extends JpaRepository<Productos, Long> {

    public Productos findByIdProducto(Long IdProducto);

    @Query(value =
            "SELECT p.idProducto, p.nombreProducto, p.precioProducto, p.descuentoProducto, p.cantidadStockProducto, p.marcaProductoTexto, SUM(c.cantidadPiezasCompra) as cantVecesComprado " +
                    "FROM productos p " +
                    "LEFT JOIN compras c on c.productoCompra = p.idProducto " +
                "WHERE p.cantidadStockProducto > 0 " +
                "GROUP BY p.idProducto " +
                "ORDER BY cantVecesComprado DESC, p.descuentoProducto DESC, p.precioProducto DESC " +
                "LIMIT 12"
            ,nativeQuery = true)
    List<ProductosCardDTO> getProductosMasVendidos();


    @Query(value =
            "SELECT p.idProducto, p.nombreProducto, p.precioProducto, p.descuentoProducto, p.cantidadStockProducto, p.marcaProductoTexto " +
                    "FROM productos p " +
                    "WHERE p.cantidadStockProducto > 0 " +
                "ORDER BY p.FechaCreacionProducto DESC " +
                "LIMIT 12"
            ,nativeQuery = true)
    List<ProductosCardDTO> getProductosNuevos();

    @Query(value =
            "SELECT idProducto, nombreProducto, descripcionProducto, precioProducto, descuentoProducto, cantidadStockProducto, marcaProductoTexto  " +
                    "FROM Productos  " +
                "WHERE IF(?1 = 0, 1, subcategoriaProducto = ?1)  " +
                "AND IF(?2 IS NULL, 1, nombreProducto LIKE CONCAT('%', ?2, '%'))  " +
                "AND cantidadStockProducto > 0  "
            ,nativeQuery = true)
    List<ProductosCardDTO> getProductosBySubcategoria(int id_subcategoria, String nombreProducto, Pageable pageable);
}
