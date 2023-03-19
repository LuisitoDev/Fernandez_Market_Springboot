package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class Categorias {

    @Id
    @Column(name = "idCategoria", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(nullable = false, length = 45)
    private String TituloCategoria;

    @Lob
    @Column(nullable = false)
    @JsonIgnore
    private byte[] imagenCategoria;

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

    public byte[] getImagenCategoria() {
        return imagenCategoria;
    }

    public void setImagenCategoria(final byte[] imagenCategoria) {
        this.imagenCategoria = imagenCategoria;
    }

}
