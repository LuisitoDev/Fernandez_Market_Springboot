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
    private String tituloSubcategoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="categoriaPadre", nullable = false)
    private Categorias categoriaPadre;

    @Column(columnDefinition = "longtext")
    @JsonIgnore
    private String imagenSubcategorias;

    @OneToMany(mappedBy = "subcategoria")
    private List<Promociones> promociones;

    @OneToMany(mappedBy = "subcategoriaProducto")
    private List<Productos> productos;

    public Integer getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(final Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getTituloSubcategoria() {
        return tituloSubcategoria;
    }

    public void setTituloSubcategoria(final String tituloSubcategoria) {
        this.tituloSubcategoria = tituloSubcategoria;
    }

    public Categorias getCategoriaPadre() {
        return categoriaPadre;
    }

    public void setCategoriaPadre(final Categorias categoriaPadre) {
        this.categoriaPadre = categoriaPadre;
    }

    public String getImagenSubcategorias() {
        return imagenSubcategorias;
    }

    public void setImagenSubcategorias(final String imagenSubcategorias) {
        this.imagenSubcategorias = imagenSubcategorias;
    }

}
