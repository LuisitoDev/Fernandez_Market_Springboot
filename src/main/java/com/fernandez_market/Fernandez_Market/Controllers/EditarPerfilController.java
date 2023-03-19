package com.fernandez_market.Fernandez_Market.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editar_perfil")
public class EditarPerfilController {

    @GetMapping
    public String getEditProfilePage(Model modelo){
        return "editUser";
    }
}
