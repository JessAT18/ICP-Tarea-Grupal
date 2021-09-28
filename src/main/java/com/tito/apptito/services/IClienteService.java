package com.tito.apptito.services;

import com.tito.apptito.entities.personas.Cliente;

import java.util.List;

public interface IClienteService {

    void grabarCliente(Cliente cliente);

    List<Cliente> listarTodosLosClientes();

    void borrarClienteById(int id);

    Cliente encontrarUnCliente(int id);


}
