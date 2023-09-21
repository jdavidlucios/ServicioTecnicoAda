package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Tecnico;
import java.util.List;

public interface ITecnicoService {
    public Tecnico crearTecnico(Tecnico tecnico);
    public Tecnico actualizarTecnico(int id, Tecnico tecnico);
    public List<Tecnico> listarTecnico();
    public Tecnico listarTecnicoID(int id);
    public void eliminarTecnico(int id);
}