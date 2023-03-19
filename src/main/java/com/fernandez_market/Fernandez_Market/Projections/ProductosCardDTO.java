package com.fernandez_market.Fernandez_Market.Projections;

import java.math.BigDecimal;

public interface ProductosCardDTO {

    Long getIdProducto();
    String getNombreProducto();
    String getDescripcionProducto();
    Long getCantVecesComprado();
    BigDecimal getPrecioProducto();
    BigDecimal getDescuentoProducto();
    Integer getCantidadStockProducto();
    String getMarcaProductoTexto();
}
