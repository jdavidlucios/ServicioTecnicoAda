package com.ada.serviciotecnicoada.service.serviceImpl;

import com.ada.serviciotecnicoada.entity.Cliente;
import com.ada.serviciotecnicoada.repository.IClienteRepository;
import com.ada.serviciotecnicoada.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("clienteServiceImpl")
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository objClienteRepo;

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> listarClientes = new ArrayList<>();
        listarClientes = objClienteRepo.findAll();
        return listarClientes;
    }

    @Override
    public Cliente listarClienteId(int id) {
        return objClienteRepo.findById(id).orElse(null);
    }

    @Override
    public Cliente crearCliente(Cliente crearCliente) {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente = objClienteRepo.save(crearCliente);
        return nuevoCliente;
    }

    @Override
    public Cliente actualizarCliente(int id, Cliente clienteActualizado) {
        Cliente clienteParaActualizar = objClienteRepo.findById(id).orElse(null);
        clienteParaActualizar.setNombres(clienteActualizado.getNombres());
        clienteParaActualizar.setApellido1(clienteActualizado.getApellido1());
        clienteParaActualizar.setApellido2(clienteActualizado.getApellido2());
        return objClienteRepo.save(clienteParaActualizar);
    }

    @Override
    public void eliminarCliente(int id) {
        objClienteRepo.deleteById(id);
    }

}
