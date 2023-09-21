package com.awakelab.serviciotecnicoada.service.serviceimpl;
import com.awakelab.serviciotecnicoada.entity.Tecnico;
import com.awakelab.serviciotecnicoada.entity.Usuario;
import com.awakelab.serviciotecnicoada.repository.IUsuarioRepository;
import com.awakelab.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;

    @Override
    public Usuario crearUsuario(Usuario usuarioCreado) {
        Usuario nuevoUsuario = new Tecnico();
        nuevoUsuario = objUsuarioRepo.save(usuarioCreado);
        return nuevoUsuario;
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
