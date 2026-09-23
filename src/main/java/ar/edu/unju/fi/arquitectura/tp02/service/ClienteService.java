package ar.edu.unju.fi.arquitectura.tp02.service;

import ar.edu.unju.fi.arquitectura.tp02.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente crearCliente(Cliente cliente);
    Cliente getByCuil(Integer cuil);
    Cliente updateCliente(Integer cuil, Cliente cambios);
    List<Cliente> listClientes();
    //void deleteByCuil(Integer cuil);
}
