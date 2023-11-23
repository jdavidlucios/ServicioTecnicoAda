package com.ada.serviciotecnicoada.repository;
import com.ada.serviciotecnicoada.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{
}
