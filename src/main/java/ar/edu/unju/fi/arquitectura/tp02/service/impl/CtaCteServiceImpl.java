package ar.edu.unju.fi.arquitectura.tp02.service.impl;

import ar.edu.unju.fi.arquitectura.tp02.model.CtaCte;
import ar.edu.unju.fi.arquitectura.tp02.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CtaCteServiceImpl {
    private final CuentaRepository cuentaRepository;

    public void cobrarMantenimiento(CtaCte cuenta){
        cuenta.setSaldo(cuenta.getSaldo()-cuenta.getComision()*cuenta.getSaldo());
        cuentaRepository.save(cuenta);
    }
}
