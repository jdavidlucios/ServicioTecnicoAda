package com.awakelab.serviciotecnicoada.controller;

import com.awakelab.serviciotecnicoada.entity.Cliente;
import com.awakelab.serviciotecnicoada.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clienteCreado")
public class ClienteController {

    @Autowired
    IClienteService objClienteService;

    @GetMapping
    public String listarCliente(Model model){
        List<Cliente> listaCliente = objClienteService.listarCliente();
        model.addAttribute("atributoListaCliente", listaCliente);
        return "TemplateClientes";
    }

    @PostMapping("/crearCliente")
    public String crearCliente(@ModelAttribute Cliente cliente) {
        objClienteService.crearCliente(cliente);
        return "redirect:/clienteCreado";
    }

    @PostMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@ModelAttribute int id) {
        objClienteService.eliminarCliente(id);
        return "redirect:/clienteCreado";
    }

    @GetMapping("/actualizarCliente/{id}")
    public String actualizarCliente(@PathVariable int id,@ModelAttribute Cliente cliente){
        objClienteService.actualizarCliente(id, cliente);
        return "redirect:/clienteCreado";
    }

}
