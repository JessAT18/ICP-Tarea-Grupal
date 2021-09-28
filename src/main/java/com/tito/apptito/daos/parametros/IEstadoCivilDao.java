package com.tito.apptito.daos.parametros;

import com.tito.apptito.entities.parametros.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoCivilDao extends JpaRepository<EstadoCivil, Integer> {
}
