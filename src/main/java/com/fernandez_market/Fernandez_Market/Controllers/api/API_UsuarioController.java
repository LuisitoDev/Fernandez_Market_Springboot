package com.fernandez_market.Fernandez_Market.Controllers.api;

import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/usuario")
public class API_UsuarioController {

    private final UsuarioService usuarioService;

    public API_UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuarios> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{id_usuario}")
    public Usuarios getUsuarios(@PathVariable("id_usuario") long id_usuario){
        return usuarioService.getUsuarioById(id_usuario);
    }
}
