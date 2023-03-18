package com.fernandez_market.Fernandez_Market.Utils;

import java.math.BigDecimal;

public class PreciosUtils {

    public static BigDecimal getPrecioFinalProducto(BigDecimal precioProducto, BigDecimal descuentoProducto) {
        BigDecimal PrecioFinalProducto = precioProducto.subtract(getValorDescontado(precioProducto, descuentoProducto));

        PrecioFinalProducto = PrecioFinalProducto.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return PrecioFinalProducto;
    }


    public static BigDecimal getValorDescontado(BigDecimal precioProducto, BigDecimal descuentoProducto) {
        BigDecimal valorAux = precioProducto.multiply(descuentoProducto);
        BigDecimal divisor = new BigDecimal(100);



        BigDecimal valorDividido = valorAux.divide(divisor);

        valorDividido = valorDividido.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return valorDividido;
    }

    public static BigDecimal getProcentajeDescuentoProducto(BigDecimal descuentoProducto) {
        return descuentoProducto.setScale(0, BigDecimal.ROUND_HALF_EVEN);
    }
}

