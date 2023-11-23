package com.ada.serviciotecnicoada.restcontroller;

import com.ada.serviciotecnicoada.entity.Cliente;
import com.ada.serviciotecnicoada.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
    @Autowired
    IClienteService objClienteService;

    @GetMapping
    public List<Cliente> listarClientes(){
        return objClienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente listarClienteId(@PathVariable int id){
        return objClienteService.listarClienteId(id);
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente clienteNuevo){
        return objClienteService.crearCliente(clienteNuevo);
    }

    @PutMapping("{id}")
    public Cliente actualizarCliente(@PathVariable int id, @RequestBody Cliente cliente){
        return objClienteService.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable int id){
        objClienteService.eliminarCliente(id);
    }
}
