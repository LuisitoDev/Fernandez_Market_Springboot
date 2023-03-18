package com.fernandez_market.Fernandez_Market.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Usuarios {

    @Id
    @Column(name = "idUsuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(nullable = false, length = 30)
    private String NombreUsuario;
    @Column(nullable = false, length = 30)
    private String ApellidoPaternoUsuario;
    @Column(nullable = false, length = 30)
    private String ApellidoMaternoUsuario;

    @Column(nullable = false, length = 60)
    private String CorreoUsuario;
    @Column(nullable = false, length = 30)
    private String PasswordUsuario;

    @JsonFormat(pattern="dd-MM-yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date FechaCreacionUsuario;

    @Column(nullable = false)
    private Boolean EstadoUsuario = true;

    @OneToMany(mappedBy = "UsuarioPedido")
    private List<Pedidos> Pedidos;

    public Usuarios() {
    }

    public Usuarios(Long idUsuario, String nombreUsuario, String correoUsuario) {
        this.idUsuario = idUsuario;
        this.NombreUsuario = nombreUsuario;
        this.CorreoUsuario = correoUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.NombreUsuario = nombreUsuario;
    }

    public String getApellidoPaternoUsuario() {
        return ApellidoPaternoUsuario;
    }

    public void setApellidoPaternoUsuario(String apellidoPaternoUsuario) {
        this.ApellidoPaternoUsuario = apellidoPaternoUsuario;
    }

    public String getApellidoMaternoUsuario() {
        return ApellidoMaternoUsuario;
    }

    public void setApellidoMaternoUsuario(String apellidoMaternoUsuario) {
        this.ApellidoMaternoUsuario = apellidoMaternoUsuario;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.CorreoUsuario = correoUsuario;
    }

    public String getPasswordUsuario() {
        return PasswordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.PasswordUsuario = passwordUsuario;
    }

    public Date getFechaCreacionUsuario() {
        return FechaCreacionUsuario;
    }

    public void setFechaCreacionUsuario(Date fechaCreacionUsuario) {
        this.FechaCreacionUsuario = fechaCreacionUsuario;
    }

    public Boolean getEstadoUsuario() {
        return EstadoUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.EstadoUsuario = estadoUsuario;
    }

    public String getNombreCompletoUsuario() {
        return NombreUsuario + " " + ApellidoPaternoUsuario + " " + ApellidoMaternoUsuario;
    }
    public String getEstadoUsuarioString() {
        if (EstadoUsuario) {
            return "Activo";
        }
        else {
            return "Inactivo";
        }
    }

}
