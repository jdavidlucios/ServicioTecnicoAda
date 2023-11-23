package com.ada.serviciotecnicoada.service;

import com.ada.serviciotecnicoada.entity.Tecnico;

import java.util.List;

public interface ITecnicoService {
    List<Tecnico> listarTecnicos();

    Tecnico listarTecnicoId(int id);

    Tecnico crearTecnico(Tecnico tecnico);

    Tecnico actualizarTecnico(int id, Tecnico tecnicoActualizado);

    void eliminarTecnico(int id);
}
