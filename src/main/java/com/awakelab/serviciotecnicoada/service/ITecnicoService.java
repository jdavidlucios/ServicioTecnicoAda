package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Tecnico;
import java.util.List;

public interface ITecnicoService {
    public Tecnico crearTecnico(Tecnico nuevoTecnico);
    public Tecnico actualizarTecnico(Tecnico tecnico);
    public List<Tecnico> listarTecnico();
    public Tecnico listarTecnicoID(int idTecnico);
    public void eliminarTecnico(Tecnico tecnico);
}