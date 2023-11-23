package com.ada.serviciotecnicoada.controller;

import com.ada.serviciotecnicoada.entity.Cliente;
import com.ada.serviciotecnicoada.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    IClienteService objClienteService;

    @GetMapping
    public String listarClientes(Model model){
        List<Cliente>listarClientes = objClienteService.listarClientes();
        model.addAttribute("atributoListarClientes", listarClientes);
        return "templateListarClientes";
    }

    @PostMapping("/crear")
    public String crearCliente(@ModelAttribute Cliente cliente, Model model){
        List<Cliente>listarClientes = objClienteService.listarClientes();
        model.addAttribute("atributoListarClientes", listarClientes);
        objClienteService.crearCliente(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("editar/{id}")
    public String actualizarCliente(@PathVariable int id, @ModelAttribute Cliente cliente){
        objClienteService.actualizarCliente(id, cliente);
        return "redirect:/clientes";
    }

    @PostMapping("eliminar/{id}")
    public String eliminarCliente(@PathVariable int id){
        objClienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
