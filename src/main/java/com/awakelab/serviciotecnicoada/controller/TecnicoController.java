package com.awakelab.serviciotecnicoada.controller;

import com.awakelab.serviciotecnicoada.entity.Tecnico;
import com.awakelab.serviciotecnicoada.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    private ITecnicoService tecnicoService;

    @GetMapping
    public String listarTecnicos(Model model) {
        List<Tecnico> listaTecnicos = tecnicoService.listarTecnicos();
        model.addAttribute("atributoListaTecnicos", listaTecnicos);
        return "templateListarTecnicos";
    }

    @GetMapping("/crearTecnico")
    public String mostrarFormularioCrearTecnico(Model model) {
        // Aquí puedes agregar lógica para obtener los datos necesarios, si es necesario
        return "templateFormularioCrearTecnico";
    }

    @PostMapping("/crearTecnico")
    public String crearTecnico(@ModelAttribute Tecnico tecnico) {
        tecnicoService.crearTecnico(tecnico);
        return "redirect:/tecnico";
    }

    @PostMapping("/eliminarTecnico/{id}")
    public String eliminarTecnico(@PathVariable int id) {
        tecnicoService.eliminarTecnico(id);
        return "redirect:/tecnico";
    }

    @GetMapping("/editarTecnico/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Tecnico tecnico = tecnicoService.obtenerTecnicoPorId(id);

        if (tecnico == null) {
            // Manejo de error si el técnico no existe
            return "redirect:/tecnico";
        }

        // Aquí puedes agregar lógica para obtener los datos necesarios, si es necesario

        model.addAttribute("tecnico", tecnico);
        return "templateFormularioEditarTecnico";
    }

    @PostMapping("/editarTecnico/{id}")
    public String actualizarTecnico(@PathVariable int id, @ModelAttribute Tecnico tecnico) {
        // Lógica para actualizar el técnico en la base de datos
        tecnicoService.actualizarTecnico(tecnico);
        // Redirecciona a la página de lista de técnicos o a donde desees después de la edición
        return "redirect:/tecnico";
    }
}