package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Cliente;
import jakarta.ws.rs.client.Client;
import java.util.List;

public interface IClienteService {
        public Cliente crearCliente(Cliente nuevoCliente);
        public Cliente actualizarCliente(Cliente cliente);
        public List<Cliente> listarCliente();
        public Cliente listarClienteID(int idCliente);
        public void eliminarCliente(Cliente cliente);
}
