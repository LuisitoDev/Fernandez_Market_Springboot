package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Promociones {

    @Id
    @Column(name = "idPromocion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromocion;

    @Column(nullable = false, columnDefinition = "longtext")
    @JsonIgnore
    private String imagenPromocion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idSubcategoria", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subcategorias subcategoria;

    public Long getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(final Long idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getImagenPromocion() {
        return imagenPromocion;
    }

    public void setImagenPromocion(final String imagenPromocion) {
        this.imagenPromocion = imagenPromocion;
    }

    public Subcategorias getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(final Subcategorias subcategoria) {
        this.subcategoria = subcategoria;
    }

}
