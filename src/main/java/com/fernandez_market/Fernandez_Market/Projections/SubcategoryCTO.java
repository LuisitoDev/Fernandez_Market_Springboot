package com.fernandez_market.Fernandez_Market.Projections;

import com.fernandez_market.Fernandez_Market.Models.Categorias;
import org.springframework.beans.factory.annotation.Value;

public interface SubcategoryCTO {

    public Integer getIdSubcategoria();
    public String getTituloSubcategoria();

    public Integer getCantidadProductos();
}
