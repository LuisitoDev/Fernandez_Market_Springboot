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

    @Lob
    @Column(nullable = false)
    @JsonIgnore
    private byte[] imagenMarca;

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

    public byte[] getImagenMarca() {
        return imagenMarca;
    }

    public void setImagenMarca(final byte[] imagenMarca) {
        this.imagenMarca = imagenMarca;
    }

    public String getPaginaMarca() {
        return PaginaMarca;
    }

    public void setPaginaMarca(final String paginaMarca) {
        this.PaginaMarca = paginaMarca;
    }

}
