package com.fernandez_market.Fernandez_Market.Controllers.api;

import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuario")
public class API_UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public API_UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuarios> getStudents(){
        return usuarioService.getUsuarios();
    }
}