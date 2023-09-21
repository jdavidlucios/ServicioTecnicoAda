package com.awakelab.serviciotecnicoada.controller;

import com.awakelab.serviciotecnicoada.entity.Cliente;
import com.awakelab.serviciotecnicoada.entity.Tecnico;
import com.awakelab.serviciotecnicoada.service.IClienteService;
import com.awakelab.serviciotecnicoada.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tecnicoCreado")
public class TecnicoController {

    @Autowired
    ITecnicoService objTecnicoService;

    @GetMapping
    public String listarTecnico(Model model){
        List<Tecnico> listaTecnico = objTecnicoService.listarTecnico();
        model.addAttribute("atributoListaTecnico", listaTecnico);
        return "TemplateTecnicos";
    }

    @PostMapping("/crearTecnico")
    public String crearTecnico(@ModelAttribute Tecnico tecnico) {
        objTecnicoService.crearTecnico(tecnico);
        return "redirect:/tecnicoCreado";
    }

    @PostMapping("/eliminarTecnico/{id}")
    public String eliminarTecnico(@PathVariable int id) {
        objTecnicoService.eliminarTecnico(id);
        return "redirect:/tecnicoCreado";
    }

    @GetMapping("/actualizarTecnico/{id}")
    public String actualizarTecnico(@PathVariable int id,@ModelAttribute Tecnico tecnico){
        objTecnicoService.actualizarTecnico(id, tecnico);
        return "redirect:/tecnicoCreado";
    }

}
