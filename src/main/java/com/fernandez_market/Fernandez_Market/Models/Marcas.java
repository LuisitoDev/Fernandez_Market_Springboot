package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Marcas {

    @Id
    @Column(name = "idMarca", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarca;

    @Column(nullable = false, length = 45)
    private String nombreMarca;

    @Column(columnDefinition = "longtext")
    @JsonIgnore
    private String imagenMarca;

    @Column(length = 100)
    private String paginaMarca;

    @OneToMany(mappedBy = "marcaProducto")
    private List<Productos> productos;

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(final Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(final String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getImagenMarca() {
        return imagenMarca;
    }

    public void setImagenMarca(final String imagenMarca) {
        this.imagenMarca = imagenMarca;
    }

    public String getPaginaMarca() {
        return paginaMarca;
    }

    public void setPaginaMarca(final String paginaMarca) {
        this.paginaMarca = paginaMarca;
    }

    public String getNombreCategoria() {
        return "Marca::getNombreCategoria DUMMY";
    }
}
