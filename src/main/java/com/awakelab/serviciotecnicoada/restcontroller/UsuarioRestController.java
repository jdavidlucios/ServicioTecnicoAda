package com.awakelab.serviciotecnicoada.restcontroller;

import com.awakelab.serviciotecnicoada.entity.Usuario;
import com.awakelab.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService objUsuarioService;

    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id) {

        return objUsuarioService.listarUsuarioID(id);
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){

        return objUsuarioService.crearUsuario(usuario);
    }
    /*@PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = objUsuarioService.crearUsuario(usuario);
        // Agrega la lógica necesaria para devolver una respuesta adecuada
        if (nuevoUsuario != null) {
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

    /*@PostMapping("/crearUsuario")
    public ResponseEntity<String> crearUsuario(@RequestParam("nombreUsuario") String nombreUsuario,
                                               @RequestParam("apellido1Usuario") String apellido1Usuario,
                                               @RequestParam("apellido2Usuario") String apellido2Usuario,
                                               @RequestParam("contrasenaUsuario") String contrasenaUsuario,
                                               @RequestParam("rolUsuario") String rolUsuario,
                                               @RequestParam("emailCliente") String emailCliente,
                                               @RequestParam("telefonoCliente") String telefonoCliente,
                                               @RequestParam("emailTecnico") String emailTecnico,
                                               @RequestParam("telefonoTecnico") String telefonoTecnico) {

        objUsuarioService.crearUsuario(nombreUsuario, apellido1Usuario, apellido2Usuario, contrasenaUsuario,
                rolUsuario, emailCliente, telefonoCliente, emailTecnico, telefonoTecnico);

        // Devolver una respuesta apropiada
        return ResponseEntity.ok("Usuario creado exitosamente");
    }*/

    @GetMapping
    public List<Usuario> listarUsuarios() {

        return objUsuarioService.listarUsuario();
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {

        return objUsuarioService.actualizarUsuario(id, usuario);

    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {

        objUsuarioService.eliminarUsuario(id);
    }
}
