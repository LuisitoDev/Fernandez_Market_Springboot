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

    @Column(columnDefinition = "longtext")
    @JsonIgnore
    private String ImagenSubcategorias;

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

    public void setTituloSubcategoria(final String tituloSubcategoria) {
        this.TituloSubcategoria = tituloSubcategoria;
    }

    public Categorias getCategoriaPadre() {
        return CategoriaPadre;
    }

    public void setCategoriaPadre(final Categorias categoriaPadre) {
        this.CategoriaPadre = categoriaPadre;
    }

    public String getImagenSubcategorias() {
        return ImagenSubcategorias;
    }

    public void setImagenSubcategorias(final String imagenSubcategorias) {
        this.ImagenSubcategorias = imagenSubcategorias;
    }

}
