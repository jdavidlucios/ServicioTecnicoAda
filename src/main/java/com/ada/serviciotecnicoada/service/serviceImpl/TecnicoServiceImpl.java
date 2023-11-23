package com.ada.serviciotecnicoada.service.serviceImpl;

import com.ada.serviciotecnicoada.entity.Tecnico;
import com.ada.serviciotecnicoada.repository.ITecnicoRepository;
import com.ada.serviciotecnicoada.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("tecnicoServiceImpl")
public class TecnicoServiceImpl implements ITecnicoService {

    @Autowired
    ITecnicoRepository objTecnicoRepo;

    @Override
    public List<Tecnico> listarTecnicos() {
        List<Tecnico> listarTecnicos = new ArrayList<>();
        listarTecnicos = objTecnicoRepo.findAll();
        return listarTecnicos;
    }

    @Override
    public Tecnico listarTecnicoId(int id)   {
        return objTecnicoRepo.findById(id).orElse(null);
    }

    @Override
    public Tecnico crearTecnico(Tecnico tecnico) {
        Tecnico nuevoTecnico = new Tecnico();
        nuevoTecnico = objTecnicoRepo.save(tecnico);
        return nuevoTecnico;
    }

    @Override
    public Tecnico actualizarTecnico(int id, Tecnico tecnicoActualizado) {
        Tecnico tecnicoParaActualizar = objTecnicoRepo.findById(id).orElse(null);
        tecnicoParaActualizar.setNombres(tecnicoActualizado.getNombres());
        tecnicoParaActualizar.setApellido1(tecnicoActualizado.getApellido1());
        tecnicoParaActualizar.setApellido2(tecnicoActualizado.getApellido2());
        return objTecnicoRepo.save(tecnicoActualizado);
    }

    @Override
    public void eliminarTecnico(int id)  {
        objTecnicoRepo.deleteById(id);
    }
}
