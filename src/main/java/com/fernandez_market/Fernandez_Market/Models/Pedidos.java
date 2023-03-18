package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    @Column(nullable = false)
    private Date FechaCreacionPedido;

    @Column(nullable = false, length = 200)
    private String DomicilioPedido;

    @Column(nullable = false, length = 20)
    private String TelefonoClientePedido;

    @Column(nullable = false, length = 45)
    private String BancoClientePedido;

    @Column(nullable = false, length = 20)
    private String NumCuentaClientePedido;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal PrecioTotalPedido;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
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
        return FechaCreacionPedido;
    }

    public void setFechaCreacionPedido(final Date fechaCreacionPedido) {
        this.FechaCreacionPedido = fechaCreacionPedido;
    }

    public String getDomicilioPedido() {
        return DomicilioPedido;
    }

    public void setDomicilioPedido(final String domicilioPedido) {
        this.DomicilioPedido = domicilioPedido;
    }

    public String getTelefonoClientePedido() {
        return TelefonoClientePedido;
    }

    public void setTelefonoClientePedido(final String telefonoClientePedido) {
        this.TelefonoClientePedido = telefonoClientePedido;
    }

    public String getBancoClientePedido() {
        return BancoClientePedido;
    }

    public void setBancoClientePedido(final String bancoClientePedido) {
        this.BancoClientePedido = bancoClientePedido;
    }

    public String getNumCuentaClientePedido() {
        return NumCuentaClientePedido;
    }

    public void setNumCuentaClientePedido(final String numCuentaClientePedido) {
        this.NumCuentaClientePedido = numCuentaClientePedido;
    }

    public BigDecimal getPrecioTotalPedido() {
        return PrecioTotalPedido;
    }

    public void setPrecioTotalPedido(final BigDecimal precioTotalPedido) {
        this.PrecioTotalPedido = precioTotalPedido;
    }

    public Usuarios getUsuarioPedido() {
        return UsuarioPedido;
    }

    public void setUsuarioPedido(final Usuarios usuarioPedido) {
        this.UsuarioPedido = usuarioPedido;
    }

}
