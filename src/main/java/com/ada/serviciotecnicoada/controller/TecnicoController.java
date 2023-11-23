package com.ada.serviciotecnicoada.controller;

import com.ada.serviciotecnicoada.entity.Tecnico;
import com.ada.serviciotecnicoada.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tecnicos")
public class TecnicoController {
    @Autowired
    ITecnicoService objTecnicoService;

    @GetMapping
    public String listarTecnicos(Model model){
        List<Tecnico>listarTecnicos = objTecnicoService.listarTecnicos();
        model.addAttribute("atributoListarTecnicos", listarTecnicos);
        return "templateListarTecnicos";
    }

    @PostMapping("/crear")
    public String crearTecnico(@ModelAttribute Tecnico tecnico, Model model){
        List<Tecnico>listarTecnicos = objTecnicoService.listarTecnicos();
        model.addAttribute("atributoListarTecnicos", listarTecnicos);
        objTecnicoService.crearTecnico(tecnico);
        return "redirect:/tecnicos";
    }

    @PostMapping("editar/{id}")
    public String actualizarTecnico(@PathVariable int id, @ModelAttribute Tecnico tecnico){
        objTecnicoService.actualizarTecnico(id, tecnico);
        return "redirect:/tecnicos";
    }

    @PostMapping("eliminar/{id}")
    public String eliminarTecnico(@PathVariable int id){
        objTecnicoService.eliminarTecnico(id);
        return "redirect:/tecnicos";
    }
}
