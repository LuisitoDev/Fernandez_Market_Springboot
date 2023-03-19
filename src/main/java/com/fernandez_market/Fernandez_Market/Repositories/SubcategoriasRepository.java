package com.fernandez_market.Fernandez_Market.Repositories;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Models.Subcategorias;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCardDTO;
import com.fernandez_market.Fernandez_Market.Projections.SubcategoryCTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SubcategoriasRepository extends JpaRepository<Subcategorias, Integer> {

    @Query(value =
            "SELECT S.IdSubcategoria, S.TituloSubcategoria, count(P.IdProducto) CantidadProductos  " +
                    "FROM productos AS P   " +
                    "INNER JOIN Subcategorias AS S ON S.IdSubcategoria = P.SubcategoriaProducto   " +
                "WHERE IF(?1 = 0, 1, S.IdSubcategoria = ?1)   " +
                "AND IF(?2 IS NULL, 1, P.NombreProducto LIKE CONCAT('%', ?2, '%'))   " +
                "AND P.CantidadStockProducto > 0  "
            , nativeQuery = true)
    SubcategoryCTO getSubcategoriasByIdNombreProducto(int id_subcategoria, String nombreProducto);
}
