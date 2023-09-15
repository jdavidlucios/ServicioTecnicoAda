package com.awakelab.serviciotecnicoada.controller;

import com.awakelab.serviciotecnicoada.entity.Cliente;
import com.awakelab.serviciotecnicoada.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> listaClientes = clienteService.listarClientes();
        model.addAttribute("atributoListaClientes", listaClientes);
        return "templateListarClientes";
    }

    @GetMapping("/crearCliente")
    public String mostrarFormularioCrearCliente(Model model) {
        // Aquí puedes agregar lógica para obtener los datos necesarios, si es necesario
        return "templateFormularioCrearCliente";
    }

    @PostMapping("/crearCliente")
    public String crearCliente(@ModelAttribute Cliente cliente) {
        clienteService.crearCliente(cliente);
        return "redirect:/cliente";
    }

    @PostMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable int id) {
        clienteService.eliminarCliente(id);
        return "redirect:/cliente";
    }

    @GetMapping("/editarCliente/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Cliente cliente = clienteService.obtenerClientePorId(id);

        if (cliente == null) {
            // Manejo de error si el cliente no existe
            return "redirect:/cliente";
        }

        // Aquí puedes agregar lógica para obtener los datos necesarios, si es necesario

        model.addAttribute("cliente", cliente);
        return "templateFormularioEditarCliente";
    }

    @PostMapping("/editarCliente/{id}")
    public String actualizarCliente(@PathVariable int id, @ModelAttribute Cliente cliente) {
        // Lógica para actualizar el cliente en la base de datos
        clienteService.actualizarCliente(cliente);
        // Redirecciona a la página de lista de clientes o a donde desees después de la edición
        return "redirect:/cliente";
    }
}
