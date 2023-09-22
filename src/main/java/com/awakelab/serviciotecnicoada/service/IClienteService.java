package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Cliente;

import java.util.List;

public interface IClienteService {
        public Cliente crearCliente(Cliente clienteCreado);
        public Cliente actualizarCliente(int id, Cliente cliente);
        public List<Cliente> listarCliente();
        public Cliente listarClienteID(int id);
        public void eliminarCliente(int id);
        void eliminarCliente2(Cliente cliente);
}
