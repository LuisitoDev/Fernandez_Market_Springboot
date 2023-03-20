package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
public class Pedidos {

    @Id
    @Column(name = "idPedido", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @JsonFormat(pattern="dd-MM-yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaCreacionPedido", nullable = false)
    private Date fechaCreacionPedido;

    @Column(name = "DomicilioPedido", nullable = false, length = 200)
    private String domicilioPedido;

    @Column(name = "TelefonoClientePedido", nullable = false, length = 20)
    private String telefonoClientePedido;

    @Column(name = "BancoClientePedido", nullable = false, length = 45)
    private String bancoClientePedido;

    @Column(name = "NumCuentaClientePedido", nullable = false, length = 20)
    private String numCuentaClientePedido;

    @Column(name = "PrecioTotalPedido", nullable = false, precision = 19, scale = 2)
    private BigDecimal precioTotalPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UsuarioPedido", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuarios UsuarioPedido;

    @OneToMany(mappedBy = "PedidoCompra")
    private List<Compras> Compras;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(final Long idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaCreacionPedido() {
        return fechaCreacionPedido;
    }

    public void setFechaCreacionPedido(final Date fechaCreacionPedido) {
        this.fechaCreacionPedido = fechaCreacionPedido;
    }

    public String getDomicilioPedido() {
        return domicilioPedido;
    }

    public void setDomicilioPedido(final String domicilioPedido) {
        this.domicilioPedido = domicilioPedido;
    }

    public String getTelefonoClientePedido() {
        return telefonoClientePedido;
    }

    public void setTelefonoClientePedido(final String telefonoClientePedido) {
        this.telefonoClientePedido = telefonoClientePedido;
    }

    public String getBancoClientePedido() {
        return bancoClientePedido;
    }

    public void setBancoClientePedido(final String bancoClientePedido) {
        this.bancoClientePedido = bancoClientePedido;
    }

    public String getNumCuentaClientePedido() {
        return numCuentaClientePedido;
    }

    public void setNumCuentaClientePedido(final String numCuentaClientePedido) {
        this.numCuentaClientePedido = numCuentaClientePedido;
    }

    public BigDecimal getPrecioTotalPedido() {
        return precioTotalPedido;
    }

    public void setPrecioTotalPedido(final BigDecimal precioTotalPedido) {
        this.precioTotalPedido = precioTotalPedido;
    }


}
