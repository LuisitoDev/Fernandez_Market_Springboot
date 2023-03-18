package com.fernandez_market.Fernandez_Market.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;


@Entity
public class Compras {

    @Id
    @Column(name = "idCompra", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idPedido", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pedidos pedidoCompra;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idProducto", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Productos productoCompra;

    @Column(nullable = false)
    private Integer cantidadPiezasCompra;

    @Column(precision = 19, scale = 2)
    private BigDecimal precioProductoCompra;

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(final Long idCompra) {
        this.idCompra = idCompra;
    }

    public Pedidos getPedidoCompra() {
        return pedidoCompra;
    }

    public void setPedidoCompra(final Pedidos pedidoCompra) {
        this.pedidoCompra = pedidoCompra;
    }

    public Productos getProductoCompra() {
        return productoCompra;
    }

    public void setProductoCompra(final Productos productoCompra) {
        this.productoCompra = productoCompra;
    }

    public Integer getCantidadPiezasCompra() {
        return cantidadPiezasCompra;
    }

    public void setCantidadPiezasCompra(final Integer cantidadPiezasCompra) {
        this.cantidadPiezasCompra = cantidadPiezasCompra;
    }

    public BigDecimal getPrecioProductoCompra() {
        return precioProductoCompra;
    }

    public void setPrecioProductoCompra(final BigDecimal precioProductoCompra) {
        this.precioProductoCompra = precioProductoCompra;
    }

}
