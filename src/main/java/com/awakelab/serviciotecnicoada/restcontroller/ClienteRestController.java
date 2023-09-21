package com.awakelab.serviciotecnicoada.restcontroller;

import com.awakelab.serviciotecnicoada.entity.Cliente;
import com.awakelab.serviciotecnicoada.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clienteCreado")
public class ClienteRestController {
    @Autowired
    IClienteService objClienteService;

    @GetMapping("/{id}")
    public Cliente listarClienteID(@PathVariable int id) {

        return objClienteService.listarClienteID(id);
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente){

        return objClienteService.crearCliente(cliente);
    }
    @GetMapping
    public List<Cliente> listarCliente() {

        return objClienteService.listarCliente();
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable int id, @RequestBody Cliente cliente){

        return objClienteService.actualizarCliente(id, cliente);

    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable int id){

        objClienteService.eliminarCliente(id);
    }
}
