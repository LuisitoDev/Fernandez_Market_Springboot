package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Categorias {

    @Id
    @Column(name = "idCategoria", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(nullable = false, length = 45)
    private String TituloCategoria;

    @Column(nullable = false, columnDefinition = "longtext")
    @JsonIgnore
    private String ImagenCategoria;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(final Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTituloCategoria() {
        return TituloCategoria;
    }

    public void setTituloCategoria(final String tituloCategoria) {
        this.TituloCategoria = tituloCategoria;
    }

    public String getImagenCategoria() {
        return ImagenCategoria;
    }

    public void setImagenCategoria(final String imagenCategoria) {
        this.ImagenCategoria = imagenCategoria;
    }

}
