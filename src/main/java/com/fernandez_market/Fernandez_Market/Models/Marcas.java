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

    @Column(name = "NombreMarca", nullable = false, length = 45)
    private String nombreMarca;

    @Lob
    @Column(name = "ImagenMarca", nullable = false)
    @JsonIgnore
    private byte[] imagenMarca;

    @Column(name = "PaginaMarca", length = 100)
    private String paginaMarca;

    @OneToMany(mappedBy = "MarcaProducto")
    private List<Productos> Productos;

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

    public byte[] getImagenMarca() {
        return imagenMarca;
    }

    public void setImagenMarca(final byte[] imagenMarca) {
        this.imagenMarca = imagenMarca;
    }

    public String getPaginaMarca() {
        return paginaMarca;
    }

    public void setPaginaMarca(final String paginaMarca) {
        this.paginaMarca = paginaMarca;
    }

}
