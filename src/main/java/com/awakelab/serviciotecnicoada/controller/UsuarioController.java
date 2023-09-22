package com.awakelab.serviciotecnicoada.controller;

import com.awakelab.serviciotecnicoada.entity.Cliente;
import com.awakelab.serviciotecnicoada.entity.Tecnico;
import com.awakelab.serviciotecnicoada.entity.Usuario;
import com.awakelab.serviciotecnicoada.repository.IClienteRepository;
import com.awakelab.serviciotecnicoada.repository.ITecnicoRepository;
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
    private IUsuarioService objUsuarioService;

    @GetMapping
    public String listarUsuario(Model model){
        List<Usuario> listaUsuario = objUsuarioService.listarUsuario();
        model.addAttribute("atributoListaUsuario", listaUsuario);
        return "TemplateUsuarios";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuarioCreado";
    }

    /*@PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario, Model model) {
        Usuario nuevoUsuario = objUsuarioService.crearUsuario(usuario);
        // Agrega la lógica necesaria para redireccionar a una vista después de crear el usuario
        return "redirect:/usuarioCreado" + nuevoUsuario.getId();
    }*/

    /*@PostMapping("/usuario/crearUsuario")
    public String crearUsuario(@RequestParam("nombreUsuario") String nombreUsuario,
                               @RequestParam("apellido1Usuario") String apellido1Usuario,
                               @RequestParam("apellido2Usuario") String apellido2Usuario,
                               @RequestParam("contrasenaUsuario") String contrasenaUsuario,
                               @RequestParam("rolUsuario") String rolUsuario,
                               @RequestParam("emailCliente") String emailCliente,
                               @RequestParam("telefonoCliente") String telefonoCliente,
                               @RequestParam("emailTecnico") String emailTecnico,
                               @RequestParam("telefonoTecnico") String telefonoTecnico) {

        objUsuarioService.crearUsuario(nombreUsuario, apellido1Usuario, apellido2Usuario, contrasenaUsuario,
                rolUsuario, emailCliente, telefonoCliente, emailTecnico, telefonoTecnico);

        // Redireccionar o mostrar una vista apropiada
        return "redirect:/usuarioCreado";
    }*/

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
