package com.awakelab.serviciotecnicoada.controller;

import com.awakelab.serviciotecnicoada.entity.Usuario;
import com.awakelab.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarioCreado")
public class UsuarioController {

    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping
    public String listarUsuario(Model model){
        List<Usuario> listaUsuario = objUsuarioService.listarUsuario();
        model.addAttribute("atributoListaUsuario", listaUsuario);
        return "TemplateUsuarios";
    }

    @GetMapping("/crearUsuario")
    public String mostrarFormularioCrearUsuario(Model model) {
        // Aquí puedes agregar lógica para obtener los datos necesarios, si es necesario
        return "TemplateUsuarios";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuarioCreado";
    }

    @PostMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@ModelAttribute int id) {
        objUsuarioService.eliminarUsuario(id);
        return "redirect:/usuarioCreado";
    }

    @GetMapping("/editarUsuario/{id}")
    public String actualizarUsuario(@PathVariable int id,@ModelAttribute Usuario usuario){
        objUsuarioService.actualizarUsuario(id, usuario);
        return "redirect:/usuarioCreado";
    }

}
