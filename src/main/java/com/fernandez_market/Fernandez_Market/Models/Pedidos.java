package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Date fechaCreacionPedido = new Date()   ;

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

    @JsonIgnore
    @Transient
    private String Calle;
    @JsonIgnore
    @Transient
    private String N_Int;
    @JsonIgnore
    @Transient
    private String N_Ext;
    @JsonIgnore
    @Transient
    private String Colonia;
    @JsonIgnore
    @Transient
    private String Estado;
    @JsonIgnore
    @Transient
    private String Municipio;
    @JsonIgnore
    @Transient
    private String CP;



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


    public void setUsuarioPedido(Usuarios usuarioPedido) {
        UsuarioPedido = usuarioPedido;
    }

    public void createDireccionCompleta() {
        try {


            String[] parts = this.domicilioPedido.split(", ");

            Calle = parts[0];
            String numeroCompleto = parts[1];
            Colonia = parts[2];
            Municipio = parts[3];
            Estado = parts[4];
            CP = parts[5];


            String[] numeros = numeroCompleto.split(" - ");

            N_Int = numeros[0];
            if (numeros.length == 2)
                N_Ext = numeros[1];

        }
        catch(Exception  e) {
            Calle = "";
            String numeroCompleto = "";
            Colonia = "";
            Municipio = "";
            Estado = "";
            CP = "";

            N_Int = "";
            N_Ext = "";

            this.telefonoClientePedido = "";
            this.bancoClientePedido = "";
            this.numCuentaClientePedido = "";
        }

    }


    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public String getN_Int() {
        return N_Int;
    }

    public void setN_Int(String n_Int) {
        N_Int = n_Int;
    }

    public String getN_Ext() {
        return N_Ext;
    }

    public void setN_Ext(String n_Ext) {
        N_Ext = n_Ext;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String colonia) {
        Colonia = colonia;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }


}
