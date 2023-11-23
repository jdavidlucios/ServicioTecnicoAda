package com.ada.serviciotecnicoada.service;

import com.ada.serviciotecnicoada.entity.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> listarClientes();

    Cliente listarClienteId(int id);

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(int id, Cliente clienteActualizado);

    void eliminarCliente(int id);
}
