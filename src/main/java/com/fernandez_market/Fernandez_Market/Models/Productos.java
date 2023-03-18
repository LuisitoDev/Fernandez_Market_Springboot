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

    @Column(nullable = false, length = 60)
    private String NombreProducto;

    @Column(length = 500)
    private String DescripcionProducto;

    @Column(columnDefinition = "longtext")
    @JsonIgnore
    private String ImagenProducto;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal PrecioProducto;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal DescuentoProducto;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date FechaCreacionProducto;

    @Column(nullable = false)
    private Integer CantidadStockProducto;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "MarcaProducto", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Marcas MarcaProducto;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SubcategoriaProducto", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subcategorias SubcategoriaProducto;

    @Column(length = 45, nullable = false)
    private String MarcaProductoTexto;

    @OneToMany(mappedBy = "ProductoCompra")
    private List<Compras> Compras;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private Long CantVecesComprado;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(final Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(final String nombreProducto) {
        this.NombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(final String descripcionProducto) {
        this.DescripcionProducto = descripcionProducto;
    }

    public String getImagenProducto() {
        return ImagenProducto;
    }

    public void setImagenProducto(final String imagenProducto) {
        this.ImagenProducto = imagenProducto;
    }

    public BigDecimal getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(final BigDecimal precioProducto) {
        this.PrecioProducto = precioProducto;
    }

    public BigDecimal getPrecioFinalProducto() {
        BigDecimal PrecioFinalProducto = this.PrecioProducto.subtract(getValorDescontado());

        PrecioFinalProducto = PrecioFinalProducto.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return PrecioFinalProducto;
    }

    public BigDecimal getValorDescontado() {
        BigDecimal valorAux = this.PrecioProducto.multiply(this.DescuentoProducto);
        BigDecimal divisor = new BigDecimal(100);

        BigDecimal valorDividido = valorAux.divide(divisor);

        valorDividido = valorDividido.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return valorDividido;
    }

    public BigDecimal getDescuentoProducto() {
        return DescuentoProducto;
    }

    public BigDecimal getProcentajeDescuentoProducto() {
        return this.DescuentoProducto.setScale(0, BigDecimal.ROUND_HALF_EVEN);
    }

    public void setDescuentoProducto(final BigDecimal descuentoProducto) {
        this.DescuentoProducto = descuentoProducto;
    }

    public Date getFechaCreacionProducto() {
        return FechaCreacionProducto;
    }

    public void setFechaCreacionProducto(final Date fechaCreacionProducto) {
        this.FechaCreacionProducto = fechaCreacionProducto;
    }

    public Integer getCantidadStockProducto() {
        return CantidadStockProducto;
    }

    public void setCantidadStockProducto(final Integer cantidadStockProducto) {
        this.CantidadStockProducto = cantidadStockProducto;
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
        return MarcaProductoTexto;
    }

    public void setMarcaProductoTexto(final String marcaProductoTexto) {
        this.MarcaProductoTexto = marcaProductoTexto;
    }

}
