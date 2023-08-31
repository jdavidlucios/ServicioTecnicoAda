package com.awakelab.serviciotecnicoada.service.serviceimpl;
import com.awakelab.serviciotecnicoada.entity.Tecnico;
import com.awakelab.serviciotecnicoada.repository.ITecnicoRepository;
import com.awakelab.serviciotecnicoada.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("tecnicoServiceImpl")
public class TecnicoServiceImpl implements ITecnicoService {

    @Autowired
    ITecnicoRepository objTecnicoRepo;

    @Override
    public Tecnico crearTecnico(Tecnico tecnicoCreado) {
        Tecnico nuevoTecnico = new Tecnico();
        nuevoTecnico = objTecnicoRepo.save(tecnicoCreado);
        return nuevoTecnico;
    }

    @Override
    public Tecnico actualizarTecnico(Tecnico tecnico) {
        try {
            if (objTecnicoRepo.existsById(tecnico.getId())){
                tecnico.setId(tecnico.getId());
                objTecnicoRepo.save(tecnico);
            }else {
                throw new RuntimeException("UPS!!!! " + tecnico.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return tecnico;
    }

    @Override
    public List<Tecnico> listarTecnico() {
        List<Tecnico> listarTecnico = new ArrayList<Tecnico>();
        listarTecnico = objTecnicoRepo.findAll();
        return listarTecnico;
    }

    @Override
    public Tecnico listarTecnicoID(int idTecnico) {
        return objTecnicoRepo.findById(idTecnico).orElse(null);
    }

    @Override
    public void eliminarTecnico(Tecnico tecnico) {
        try {
            if (objTecnicoRepo.existsById(tecnico.getId())){
                objTecnicoRepo.deleteById(tecnico.getId());
            }else {
                throw new RuntimeException("UPS!!!! " + tecnico.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Técnico borrado exitosamente");
    }
}

