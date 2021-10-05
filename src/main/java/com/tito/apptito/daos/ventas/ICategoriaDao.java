package com.tito.apptito.daos.ventas;

import com.tito.apptito.entities.ventas.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaDao extends JpaRepository<Categoria, Integer> {
}
