package com.fernandez_market.Fernandez_Market.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    @GetMapping
    public String getProfilePage(Model modelo){
        return "profileUser";
    }
}
