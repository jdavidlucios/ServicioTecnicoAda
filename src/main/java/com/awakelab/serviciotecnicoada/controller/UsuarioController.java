package com.awakelab.serviciotecnicoada.controller;

import com.awakelab.serviciotecnicoada.entity.Usuario;
import com.awakelab.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("atributoListaUsuarios", listaUsuarios);
        return "templateListarUsuarios";
    }

    @GetMapping("/crearUsuario")
    public String mostrarFormularioCrearUsuario(Model model) {
        // Aquí puedes agregar lógica para obtener los datos necesarios, si es necesario
        return "templateFormularioCrearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }

    @PostMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuario";
    }

    @GetMapping("/editarUsuario/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);

        if (usuario == null) {
            // Manejo de error si el usuario no existe
            return "redirect:/usuario";
        }

        // Aquí puedes agregar lógica para obtener los datos necesarios, si es necesario

        model.addAttribute("usuario", usuario);
        return "templateFormularioEditarUsuario";
    }

    @PostMapping("/editarUsuario/{id}")
    public String actualizarUsuario(@PathVariable int id, @ModelAttribute Usuario usuario) {
        // Lógica para actualizar el usuario en la base de datos
        usuarioService.actualizarUsuario(usuario);
        // Redirecciona a la página de lista de usuarios o a donde desees después de la edición
        return "redirect:/usuario";
    }
}
