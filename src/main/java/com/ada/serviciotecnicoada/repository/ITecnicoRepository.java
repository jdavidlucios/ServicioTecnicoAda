package com.ada.serviciotecnicoada.repository;
import com.ada.serviciotecnicoada.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITecnicoRepository extends JpaRepository<Tecnico, Integer>{
}
