package com.fernandez_market.Fernandez_Market.Projections;

import java.math.BigDecimal;

public interface ProductosCard {

    Long getIdProducto();
    String getNombreProducto();
    Long getCantVecesComprado();
    BigDecimal getPrecioProducto();
    BigDecimal getDescuentoProducto();
    Integer getCantidadStockProducto();
    String getMarcaProductoTexto();

}
