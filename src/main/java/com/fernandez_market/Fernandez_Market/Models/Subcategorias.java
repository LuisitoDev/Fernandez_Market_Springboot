package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Subcategorias {

    @Id
    @Column(name = "idSubcategoria", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubcategoria;

    @Column(nullable = false, length = 45)
    private String TituloSubcategoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="categoriaPadre", nullable = false)
    private Categorias CategoriaPadre;

    @Lob
    @Column(nullable = false)
    @JsonIgnore
    private byte[] imagenSubcategorias;

    @OneToMany(mappedBy = "Subcategoria")
    private List<Promociones> Promociones;

    @OneToMany(mappedBy = "SubcategoriaProducto")
    private List<Productos> Productos;

    public Integer getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(final Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getTituloSubcategoria() {
        return TituloSubcategoria;
    }

    public String getTituloSubcategoriaURL() {
        return TituloSubcategoria.replace(" ", "-");
    }

    public void setTituloSubcategoria(final String tituloSubcategoria) {
        this.TituloSubcategoria = tituloSubcategoria;
    }

    public Categorias getCategoriaPadre() {
        return CategoriaPadre;
    }

    public void setCategoriaPadre(final Categorias categoriaPadre) {
        this.CategoriaPadre = categoriaPadre;
    }

    public byte[] getImagenSubcategorias() {
        return imagenSubcategorias;
    }

    public void setImagenSubcategorias(final byte[] imagenSubcategorias) {
        this.imagenSubcategorias = imagenSubcategorias;
    }

}
