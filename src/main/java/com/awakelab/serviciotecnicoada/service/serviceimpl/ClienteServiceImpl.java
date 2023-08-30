package com.awakelab.serviciotecnicoada.service.serviceimpl;

import com.awakelab.serviciotecnicoada.entity.Cliente;
import com.awakelab.serviciotecnicoada.repository.IClienteRepository;
import com.awakelab.serviciotecnicoada.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("clienteServiceImpl")
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    IClienteRepository objClienteRepo;

    @Override
    public Cliente crearCliente(Cliente clienteCreado) {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente = objClienteRepo.save(clienteCreado);
        return nuevoCliente;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        try {
            if (objClienteRepo.existsById(cliente.getId())){
                cliente.setId(cliente.getId());
                objClienteRepo.save(cliente);
            }else {
                throw new RuntimeException("UPS!!!! " + cliente.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> listarCliente() {
        List<Cliente> listarClientes = new ArrayList<Cliente>();
        listarClientes = objClienteRepo.findAll();
        return listarClientes;
    }

    @Override
    public Cliente listarClienteID(int idCliente) {
        return objClienteRepo.findById(idCliente).orElse(null);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        try {
            if (objClienteRepo.existsById(cliente.getId())){
                objClienteRepo.deleteById(cliente.getId());
            }else {
                throw new RuntimeException("UPS!!!! " + cliente.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Cliente borrado exitosamente");
    }

}
