package com.awakelab.serviciotecnicoada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping("/Index")
    public String controladorInicio(){
        return "TemplateIndex";
    }
}
