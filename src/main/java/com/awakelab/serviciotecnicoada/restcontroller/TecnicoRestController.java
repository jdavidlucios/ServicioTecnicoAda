package com.awakelab.serviciotecnicoada.restcontroller;

import com.awakelab.serviciotecnicoada.entity.Tecnico;
import com.awakelab.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tecnico")
public class TecnicoRestController {

    @Autowired
    ITecnicoService objTecnicoService;

    @GetMapping("/{id}")
    public Tecnico listarTecnicoID(@PathVariable int id)  { return objTecnicoService.listarTecnicoID(id);
    }

    @PostMapping
    public TecnicoRestController crearTecnico(@RequestBody Tecnico nuevoTecnico) {
        return objTecnicoService.crearTecnico(tecnico);
    }

    @GetMapping
    public List<Tecnico> listarTecnico(){
        return objTecnicoService.listarTecnico();
    }

    private class ITecnicoService {
    }
}
