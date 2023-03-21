package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    private final UsuarioService usuarioService;

    public PerfilController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String getProfilePage(Model modelo, HttpServletRequest request){

        if (request.getSession().getAttribute("IdUsuarioActivo") == null){
            modelo.addAttribute("error", "No hay un usuario registrado");
            return "error";
        }

        long idUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");

        Usuarios usuarioElegido = this.usuarioService.getUsuarioById(idUsuarioActivo);

        modelo.addAttribute("usuarioElegido", usuarioElegido);

        modelo.addAttribute("listaPedidos", usuarioElegido.getPedidos());

        return "profileUser";
    }
}
