package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
public class Productos {

    @Id
    @Column(name = "idProducto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "NombreProducto", nullable = false, length = 60)
    private String nombreProducto;

    @Column(name = "DescripcionProducto", length = 500)
    private String descripcionProducto;

    @Lob
    @Column(name = "ImagenProducto", nullable = false)
    @JsonIgnore
    private byte[] imagenProducto;

    @Column(name = "PrecioProducto", nullable = false, precision = 19, scale = 2)
    private BigDecimal precioProducto;

    @Column(name = "DescuentoProducto", nullable = false, precision = 5, scale = 2)
    private BigDecimal descuentoProducto;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaCreacionProducto", nullable = false)
    private Date fechaCreacionProducto = new Date();

    @Column(name = "CantidadStockProducto", nullable = false)
    private Integer cantidadStockProducto;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "MarcaProducto", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Marcas MarcaProducto;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SubcategoriaProducto", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subcategorias SubcategoriaProducto;

    @Column(name = "MarcaProductoTexto", length = 45, nullable = false)
    private String marcaProductoTexto;

    @OneToMany(mappedBy = "ProductoCompra")
    private List<Compras> Compras;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private int CantVecesComprado;

    @JsonIgnore
    @Transient
    private int cantidadPiezasComprar;

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

    public byte[] getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(final byte[] imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(final BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public BigDecimal getPrecioFinalProducto() {
        BigDecimal PrecioFinalProducto = this.precioProducto.subtract(getValorDescontado());

        PrecioFinalProducto = PrecioFinalProducto.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return PrecioFinalProducto;
    }

    public BigDecimal getValorDescontado() {
        BigDecimal valorAux = this.precioProducto.multiply(this.descuentoProducto);
        BigDecimal divisor = new BigDecimal(100);

        BigDecimal valorDividido = valorAux.divide(divisor);

        valorDividido = valorDividido.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return valorDividido;
    }

    public BigDecimal getDescuentoProducto() {
        return descuentoProducto;
    }

    public BigDecimal getProcentajeDescuentoProducto() {
        return this.descuentoProducto.setScale(0, BigDecimal.ROUND_HALF_EVEN);
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
        return MarcaProducto;
    }

    public void setMarcaProducto(final Marcas marcaProducto) {
        this.MarcaProducto = marcaProducto;
    }

    public Subcategorias getSubcategoriaProducto() {
        return SubcategoriaProducto;
    }

    public void setSubcategoriaProducto(final Subcategorias subcategoriaProducto) {
        this.SubcategoriaProducto = subcategoriaProducto;
    }

    public String getMarcaProductoTexto() {
        return marcaProductoTexto;
    }

    public void setMarcaProductoTexto(final String marcaProductoTexto) {
        this.marcaProductoTexto = marcaProductoTexto;
    }


    public int getCantidadPiezasComprar() {
        return cantidadPiezasComprar;
    }

    public void setCantidadPiezasComprar(int cantidadPiezasComprar) {
        this.cantidadPiezasComprar = cantidadPiezasComprar;
    }

    public BigDecimal getTotalPorPiezas() {
        BigDecimal precioFinal = getPrecioFinalProducto();
        BigDecimal cantidadPiezas = new BigDecimal(cantidadPiezasComprar);

        return precioFinal.multiply(cantidadPiezas);
    }


}
