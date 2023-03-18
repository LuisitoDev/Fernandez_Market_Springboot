package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Promociones {

    @Id
    @Column(name = "idPromociones", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromociones;

    @Column(nullable = false, columnDefinition = "longtext")
    @JsonIgnore
    private String ImagenPromocion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Subcategoria", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subcategorias Subcategoria;

    public Long getIdPromocion() {
        return idPromociones;
    }

    public void setIdPromocion(final Long idPromocion) {
        this.idPromociones = idPromocion;
    }

    public String getImagenPromocion() {
        return ImagenPromocion;
    }

    public void setImagenPromocion(final String imagenPromocion) {
        this.ImagenPromocion = imagenPromocion;
    }

    public Subcategorias getSubcategoria() {
        return Subcategoria;
    }

    public void setSubcategoria(final Subcategorias subcategoria) {
        this.Subcategoria = subcategoria;
    }

}
