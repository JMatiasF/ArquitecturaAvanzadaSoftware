package ar.edu.unju.fi.arquitectura.tp02.service.impl;

import ar.edu.unju.fi.arquitectura.tp02.model.CajaAhorro;
import ar.edu.unju.fi.arquitectura.tp02.repository.CuentaRepository;
import ar.edu.unju.fi.arquitectura.tp02.service.CuentaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CajaAhorroServiceImpl{
    private final CuentaRepository cuentaRepository;
    public void calcularInteres(CajaAhorro cuenta){
        cuenta.setSaldo(cuenta.getTasainteres()*cuenta.getSaldo());
        cuentaRepository.save(cuenta);
    }
    private boolean puedeExtraer(CajaAhorro cuenta){
        if (cuenta.getCantextraccion()==0) return false;
        return true;
    }
}
