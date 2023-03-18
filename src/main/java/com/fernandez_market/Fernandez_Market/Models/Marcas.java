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
    private String NombreMarca;

    @Column(columnDefinition = "longtext")
    @JsonIgnore
    private String ImagenMarca;

    @Column(length = 100)
    private String PaginaMarca;

    @OneToMany(mappedBy = "MarcaProducto")
    private List<Productos> Productos;

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(final Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return NombreMarca;
    }

    public void setNombreMarca(final String nombreMarca) {
        this.NombreMarca = nombreMarca;
    }

    public String getImagenMarca() {
        return ImagenMarca;
    }

    public void setImagenMarca(final String imagenMarca) {
        this.ImagenMarca = imagenMarca;
    }

    public String getPaginaMarca() {
        return PaginaMarca;
    }

    public void setPaginaMarca(final String paginaMarca) {
        this.PaginaMarca = paginaMarca;
    }

}
