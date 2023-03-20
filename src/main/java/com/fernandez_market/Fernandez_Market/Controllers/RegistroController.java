package com.fernandez_market.Fernandez_Market.Controllers;


import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String getRegistroPage(Model modelo){
        return "signUp";
    }

    @PostMapping
    public String registrarUsuario(Model modelo,
                                    @RequestParam("nombre") String nombre, @RequestParam("apellidoP") String apellidoP, @RequestParam("apellidoM") String apellidoM,
                                    @RequestParam("email") String email, @RequestParam("password") String password
    ){
        Usuarios usuarioRepetido = this.usuarioService.getUsuariosByEmail(email);

        if (usuarioRepetido != null){
            modelo.addAttribute("emailEncontrado", "true");
            return "signUp";
        }

        Usuarios usuarioNuevo = new Usuarios();
        usuarioNuevo.setNombreUsuario(nombre);
        usuarioNuevo.setApellidoPaternoUsuario(apellidoP);
        usuarioNuevo.setApellidoMaternoUsuario(apellidoM);
        usuarioNuevo.setCorreoUsuario(email);
        usuarioNuevo.setPasswordUsuario(password);


        this.usuarioService.saveUsuario(usuarioNuevo);

        return "login";
    }
}
