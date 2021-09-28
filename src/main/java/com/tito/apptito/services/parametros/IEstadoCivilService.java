package com.tito.apptito.services.parametros;

import com.tito.apptito.entities.parametros.EstadoCivil;

import java.util.List;

public interface IEstadoCivilService {
    void grabarEstadoCivil(EstadoCivil estadoCivil);

    List<EstadoCivil> listarTodosLosEstadosCiviles();

    void borrarEstadoCivilById(int id);

    EstadoCivil encontrarUnEstadoCivil(int id);
}
