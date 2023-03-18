package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;


@Entity
public class Productos {

    @Id
    @Column(name = "idProducto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false, length = 60)
    private String nombreProducto;

    @Column(length = 500)
    private String descripcionProducto;

    @Column(columnDefinition = "longtext")
    @JsonIgnore
    private String imagenProducto;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal precioProducto;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal descuentoProducto;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaCreacionProducto;

    @Column(nullable = false)
    private Integer cantidadStockProducto;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idMarca", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Marcas marcaProducto;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idSubcategoria", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subcategorias subcategoriaProducto;

    @Column(length = 45, nullable = false)
    private String marcaProductoTexto;

    @OneToMany(mappedBy = "productoCompra")
    private List<Compras> compras;


    @Formula("(SELECT COUNT(*) FROM productos p " +
            "left join compras c on c.idProducto = p.idProducto " +
            "where p.idProducto = idProducto " +
            "GROUP BY p.idProducto)")
    private Long CantVecesComprado;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(final Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(final String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(final String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(final String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(final BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public BigDecimal getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(final BigDecimal descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public Date getFechaCreacionProducto() {
        return fechaCreacionProducto;
    }

    public void setFechaCreacionProducto(final Date fechaCreacionProducto) {
        this.fechaCreacionProducto = fechaCreacionProducto;
    }

    public Integer getCantidadStockProducto() {
        return cantidadStockProducto;
    }

    public void setCantidadStockProducto(final Integer cantidadStockProducto) {
        this.cantidadStockProducto = cantidadStockProducto;
    }

    public Marcas getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(final Marcas marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public Subcategorias getSubcategoriaProducto() {
        return subcategoriaProducto;
    }

    public void setSubcategoriaProducto(final Subcategorias subcategoriaProducto) {
        this.subcategoriaProducto = subcategoriaProducto;
    }

    public String getMarcaProductoTexto() {
        return marcaProductoTexto;
    }

    public void setMarcaProductoTexto(final String marcaProductoTexto) {
        this.marcaProductoTexto = marcaProductoTexto;
    }

}
