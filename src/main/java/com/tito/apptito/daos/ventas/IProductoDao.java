package com.tito.apptito.daos.ventas;

import com.tito.apptito.entities.ventas.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoDao extends JpaRepository<Producto, Integer> {
}
