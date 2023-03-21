package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/editar_perfil")
public class EditarPerfilController {

    private final UsuarioService usuarioService;

    public EditarPerfilController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String getEditProfilePage(Model modelo, HttpServletRequest request){
        if (request.getSession().getAttribute("IdUsuarioActivo") == null){
            modelo.addAttribute("error", "No hay un usuario registrado");
            return "error";
        }

        long idUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");

        Usuarios usuarioElegido = this.usuarioService.getUsuarioById(idUsuarioActivo);

        modelo.addAttribute("usuarioElegido", usuarioElegido);

        return "editUser";
    }

    @PostMapping
    public String registrarUsuario(Model modelo, HttpServletRequest request,
                                   @RequestParam("nombre") String nombre, @RequestParam("apellidoP") String apellidoP, @RequestParam("apellidoM") String apellidoM,
                                   @RequestParam("password") String password
    ){
        if (request.getSession().getAttribute("IdUsuarioActivo") == null){
            modelo.addAttribute("error", "No hay un usuario registrado");
            return "error";
        }

        long idUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");


        Usuarios usuario = this.usuarioService.getUsuarioById(idUsuarioActivo);

        usuario.setNombreUsuario(nombre);
        usuario.setApellidoPaternoUsuario(apellidoP);
        usuario.setApellidoMaternoUsuario(apellidoM);
        usuario.setPasswordUsuario(password);

        this.usuarioService.updateUsuario(usuario);

        return "redirect:/perfil";
    }
}
