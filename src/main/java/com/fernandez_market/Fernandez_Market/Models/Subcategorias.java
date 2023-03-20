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

    @Column(name = "TituloSubcategoria", nullable = false, length = 45)
    private String tituloSubcategoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CategoriaPadre", nullable = false)
    private Categorias categoriaPadre;

    @Lob
    @Column(name = "ImagenSubcategorias", nullable = false)
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
        return tituloSubcategoria;
    }

    public String getTituloSubcategoriaURL() {
        return tituloSubcategoria.replace(" ", "-");
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

    public byte[] getImagenSubcategorias() {
        return imagenSubcategorias;
    }

    public void setImagenSubcategorias(final byte[] imagenSubcategorias) {
        this.imagenSubcategorias = imagenSubcategorias;
    }

}
