package ar.edu.unju.fi.arquitectura.tp02.service;

import ar.edu.unju.fi.arquitectura.tp02.model.Cuenta;

import java.util.List;

public interface CuentaService {
    public Cuenta crearCuenta(Cuenta cuenta);
    public List<Cuenta> listCuenta();
    public Cuenta getByCbu(Integer cbu);
    public Cuenta getByAlias(String alias);
    public Cuenta updateCuenta(Integer cbu, Cuenta cambios);
    //void deleteCuenta(Integer cbu);
}
