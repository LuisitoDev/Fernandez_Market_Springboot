package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class Usuarios {

    @Id
    @Column(name = "idUsuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name = "NombreUsuario", nullable = false, length = 30)
    private String nombreUsuario;
    @Column(name = "ApellidoPaternoUsuario", nullable = false, length = 30)
    private String apellidoPaternoUsuario;
    @Column(name = "ApellidoMaternoUsuario", nullable = false, length = 30)
    private String apellidoMaternoUsuario;

    @Column(name = "CorreoUsuario", nullable = false, length = 60)
    private String correoUsuario;
    @Column(name = "PasswordUsuario", nullable = false, length = 30)
    private String passwordUsuario;

    @JsonFormat(pattern="dd-MM-yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaCreacionUsuario", nullable = false)
    private Date fechaCreacionUsuario = new Date();

    @Column(name = "EstadoUsuario", nullable = false)
    private Boolean estadoUsuario = true;

    @OneToMany(mappedBy = "UsuarioPedido")
    private List<Pedidos> Pedidos;

    public Usuarios() {
    }

    public Usuarios(Long idUsuario, String nombreUsuario, String correoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPaternoUsuario() {
        return apellidoPaternoUsuario;
    }

    public void setApellidoPaternoUsuario(String apellidoPaternoUsuario) {
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
    }

    public String getApellidoMaternoUsuario() {
        return apellidoMaternoUsuario;
    }

    public void setApellidoMaternoUsuario(String apellidoMaternoUsuario) {
        this.apellidoMaternoUsuario = apellidoMaternoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Date getFechaCreacionUsuario() {
        return fechaCreacionUsuario;
    }

    public void setFechaCreacionUsuario(Date fechaCreacionUsuario) {
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getNombreCompletoUsuario() {
        return nombreUsuario + " " + apellidoPaternoUsuario + " " + apellidoMaternoUsuario;
    }
    public String getEstadoUsuarioString() {
        if (estadoUsuario) {
            return "Activo";
        }
        else {
            return "Inactivo";
        }
    }


    public List<com.fernandez_market.Fernandez_Market.Models.Pedidos> getPedidos() {
        Collections.reverse(Pedidos);
        return Pedidos;
    }

    public void setPedidos(List<com.fernandez_market.Fernandez_Market.Models.Pedidos> pedidos) {
        Pedidos = pedidos;
    }

}
