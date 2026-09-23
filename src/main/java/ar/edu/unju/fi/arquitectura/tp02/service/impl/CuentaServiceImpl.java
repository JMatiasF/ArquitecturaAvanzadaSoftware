package ar.edu.unju.fi.arquitectura.tp02.service.impl;

import ar.edu.unju.fi.arquitectura.tp02.model.Cuenta;
import ar.edu.unju.fi.arquitectura.tp02.repository.CuentaRepository;
import ar.edu.unju.fi.arquitectura.tp02.service.CuentaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService {
    private final CuentaRepository cuentaRepository;

    @Override
    @Transactional
    public Cuenta crearCuenta(Cuenta cuenta){
        log.info("Creando cuenta nueva.");
        if (cuentaRepository.existsByCbuOrAlias(cuenta.getCbu(), cuenta.getAlias())){
            log.info("El CBU {} o el alias {} ya existen.", cuenta.getCbu(), cuenta.getAlias());
            throw new IllegalArgumentException("Falló al crear cuenta");
        }
        log.info("Cuenta creada correctamente.");
        return cuentaRepository.save(cuenta);
    }

    @Override
    @Transactional
    public Cuenta getByCbu(Integer cbu){
        log.info("Buscando cuenta con CBU: {}", cbu);
        return cuentaRepository.findByCbu(cbu).orElseThrow(()-> new IllegalArgumentException("Cuenta no encontrada"));
    }

    @Override
    @Transactional
    public List<Cuenta> listCuenta(){
        log.info("Mostrando todas las cuentas.");
        return cuentaRepository.findAll();
    }

    @Override
    @Transactional
    public Cuenta getByAlias(String alias){
        log.info("Buscando cuenta con alias: {}", alias);
        return cuentaRepository.findByAlias(alias).orElseThrow(()-> new IllegalArgumentException("Cuenta no encontrada."));
    }

    @Override
    @Transactional
    public Cuenta updateCuenta(Integer cbu, Cuenta cambios){
        log.info("Actualizando datos de la cuenta: {}", cbu);
        Cuenta cuenta= cuentaRepository.findByCbu(cbu).orElseThrow(()->new IllegalArgumentException("Cuenta no encontrada."));
        cuenta.setAlias(cambios.getAlias());
        cuenta.setEstado(cambios.getEstado());
        cuenta.setSaldo(cambios.getSaldo());
        cuenta.setTitulares(cambios.getTitulares());
        cuenta.setTransacciones(cambios.getTransacciones());
        log.info("Datos actualizados correctamente.");
        return cuentaRepository.save(cuenta);
    }
}
