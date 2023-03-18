package com.fernandez_market.Fernandez_Market.Repositories;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductosRepository extends JpaRepository<Productos, Long> {

    public Productos findByIdProducto(Long IdProducto);

    @Query(value =
            "SELECT p.idProducto, p.nombreProducto, p.precioProducto, p.descuentoProducto, p.cantidadStockProducto, p.marcaProductoTexto, SUM(c.cantidadPiezasCompra) as cantVecesComprado " +
                    "FROM productos p " +
                    "LEFT JOIN compras c on c.idProducto = p.idProducto " +
                "WHERE p.cantidadStockProducto > 0 " +
                "GROUP BY p.idProducto " +
                "ORDER BY cantVecesComprado DESC, p.descuentoProducto DESC, p.precioProducto DESC " +
                "LIMIT 12"
            ,nativeQuery = true)
    List<ProductosCard> getProductosMasVendidos();


    @Query(value =
            "SELECT p.idProducto, p.nombreProducto, p.precioProducto, p.descuentoProducto, p.cantidadStockProducto, p.marcaProductoTexto " +
                    "FROM productos p " +
                    "WHERE p.cantidadStockProducto > 0 " +
                "ORDER BY p.FechaCreacionProducto DESC " +
                "LIMIT 12"
            ,nativeQuery = true)
    List<ProductosCard> getProductosNuevos();
}
