package com.ada.serviciotecnicoada.controller;

import com.ada.serviciotecnicoada.entity.Usuario;
import com.ada.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario> listarUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("atributoListarUsuarios", listarUsuarios);
        return "templateListarUsuarios";
    }

    @PostMapping("/crear")
    public String crearUsuario(@ModelAttribute Usuario usuario, Model model){
        List<Usuario> listarUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("atributoListarUsuarios", listarUsuarios);
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("editar/{id}")
    public String actualizarUsuario(@PathVariable int id, @ModelAttribute Usuario usuario){
        objUsuarioService.actualizarUsuario(id, usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}
