package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Cliente;
import com.awakelab.serviciotecnicoada.entity.Usuario;

import java.util.List;

public interface IClienteService {
        public Cliente crearCliente(Cliente nuevoCliente);
        public Cliente actualizarCliente(int id, Cliente cliente);
        public List<Cliente> listarCliente();
        public Cliente listarClienteID(int id);
        public void eliminarCliente(int id);
        void eliminarCliente2(Cliente cliente);
}
