package com.awakelab.serviciotecnicoada.repository;

import com.awakelab.serviciotecnicoada.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
}
