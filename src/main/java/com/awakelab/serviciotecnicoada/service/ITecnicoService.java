package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Tecnico;

import java.util.List;

public interface ITecnicoService {
    public Tecnico crearTecnico(Tecnico nuevoTecnico);
    public Tecnico actualizarTecnico(int id);
    public List<Tecnico> listarTecnico();
    public Tecnico listarTecnicoID(int idTecnico);
    public void eliminarTecnico(int id);
}