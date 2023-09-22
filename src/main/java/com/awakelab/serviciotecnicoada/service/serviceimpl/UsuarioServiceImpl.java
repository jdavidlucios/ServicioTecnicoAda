package com.awakelab.serviciotecnicoada.service.serviceimpl;
import com.awakelab.serviciotecnicoada.entity.Cliente;
import com.awakelab.serviciotecnicoada.entity.Tecnico;
import com.awakelab.serviciotecnicoada.entity.Usuario;
import com.awakelab.serviciotecnicoada.repository.IClienteRepository;
import com.awakelab.serviciotecnicoada.repository.ITecnicoRepository;
import com.awakelab.serviciotecnicoada.repository.IUsuarioRepository;
import com.awakelab.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository objUsuarioRepo;

    @Autowired
    private IClienteRepository objClienteRepo;

    @Autowired
    private ITecnicoRepository objTecnicoRepo;

    /*@Override
    public Usuario crearUsuario(Usuario usuario) {
        // Verifica el rol seleccionado
        if (usuario.getRolUsuario().equals("Cliente")) {
            // Si es un cliente, crea una instancia de Cliente
            Cliente cliente = new Cliente();
            cliente.setNombreUsuario(usuario.getNombreUsuario());
            cliente.setApellido1Usuario(usuario.getApellido1Usuario());
            cliente.setApellido2Usuario(usuario.getApellido2Usuario());
            cliente.setContrasenaUsuario(usuario.getContrasenaUsuario());
            cliente.setRolUsuario(usuario.getRolUsuario());
            cliente.setEmailCliente(cliente.getEmailCliente());
            cliente.setTelefonoCliente(cliente.getTelefonoCliente());

            // Guarda el cliente en el repositorio de clientes
            return objClienteRepo.save(cliente);
        } else if (usuario.getRolUsuario().equals("Tecnico")) {
            // Si es un técnico, crea una instancia de Tecnico
            Tecnico tecnico = new Tecnico();
            tecnico.setNombreUsuario(usuario.getNombreUsuario());
            tecnico.setApellido1Usuario(usuario.getApellido1Usuario());
            tecnico.setApellido2Usuario(usuario.getApellido2Usuario());
            tecnico.setContrasenaUsuario(usuario.getContrasenaUsuario());
            tecnico.setRolUsuario(usuario.getRolUsuario());
            tecnico.setEmailTecnico(tecnico.getEmailTecnico());
            tecnico.setTelefonoTecnico(tecnico.getTelefonoTecnico());

            // Guarda el técnico en el repositorio de técnicos
            return objTecnicoRepo.save(tecnico);
        } else {
            // Manejar otro rol o caso por defecto aquí si es necesario
            return null;
        }
    }*/

    @Override
    @Transactional
    public void crearUsuario(String nombreUsuario, String apellido1Usuario, String apellido2Usuario,
                             String contrasenaUsuario, String rolUsuario, String emailCliente, String telefonoCliente,
                             String emailTecnico, String telefonoTecnico) {

        // Crear una instancia de Usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setApellido1Usuario(apellido1Usuario);
        usuario.setApellido2Usuario(apellido2Usuario);
        usuario.setContrasenaUsuario(contrasenaUsuario);
        usuario.setRolUsuario(rolUsuario);

        // Determinar el tipo de usuario (Cliente o Tecnico) y crear la instancia correspondiente
        if ("Cliente".equals(rolUsuario)) {
            Cliente cliente = new Cliente();
            cliente.setEmailCliente(emailCliente);
            cliente.setTelefonoCliente(telefonoCliente);
            cliente.setUsuario(usuario); // Establecer la relación
            usuario.setCliente(cliente); // Establecer la relación inversa
            objClienteRepo.save(cliente);
        } else if ("Tecnico".equals(rolUsuario)) {
            Tecnico tecnico = new Tecnico();
            tecnico.setEmailTecnico(emailTecnico);
            tecnico.setTelefonoTecnico(telefonoTecnico);
            tecnico.setUsuario(usuario); // Establecer la relación
            usuario.setTecnico(tecnico); // Establecer la relación inversa
            objTecnicoRepo.save(tecnico);
        }

        // Guardar el usuario en la base de datos
        objUsuarioRepo.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuario) {
        try {
            if (objUsuarioRepo.existsById(usuario.getId())){
                usuario.setId(usuario.getId());
                objUsuarioRepo.save(usuario);
            }else {
                throw new RuntimeException("UPS!!!! " + usuario.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> listarUsuario = new ArrayList<Usuario>();
        listarUsuario = objUsuarioRepo.findAll();
        return listarUsuario;
    }

    @Override
    public Usuario listarUsuarioID(int id) {
        return objUsuarioRepo.findById(id).orElse(null);
    }


    @Override
    public void eliminarUsuario(int id) {
        objUsuarioRepo.deleteById(id);
    }

    @Override
    public void eliminarUsuario2(Usuario usuario) {
        objUsuarioRepo.delete(usuario);

        System.out.println("Usuario borrado exitosamente");
    }
}
