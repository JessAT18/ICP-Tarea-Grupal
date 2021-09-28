package com.tito.apptito.daos;

import com.tito.apptito.entities.personas.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Integer> {



}
