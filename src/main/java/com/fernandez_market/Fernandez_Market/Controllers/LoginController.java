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

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String getLoginPage(Model modelo, HttpServletRequest request){
        if (request.getSession().getAttribute("IdUsuarioActivo") != null)
            request.getSession().setAttribute("IdUsuarioActivo", null);

        return "login";
    }

    @PostMapping
    public String loginUsuario(Model modelo, HttpServletRequest request, @RequestParam("email") String email, @RequestParam("password") String password){
        Usuarios usuario = this.usuarioService.getUsuariosByEmailPassword(email, password);

        if (usuario == null){
            modelo.addAttribute("usuarioIncorrecto", "true");
            return "login";
        }

        request.getSession().setAttribute("IdUsuarioActivo", usuario.getIdUsuario());

        return "redirect:/inicio";
    }
}
