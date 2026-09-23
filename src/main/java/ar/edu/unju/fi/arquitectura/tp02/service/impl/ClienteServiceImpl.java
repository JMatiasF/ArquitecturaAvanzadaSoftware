package ar.edu.unju.fi.arquitectura.tp02.service.impl;

import ar.edu.unju.fi.arquitectura.tp02.model.Cliente;
import ar.edu.unju.fi.arquitectura.tp02.repository.ClienteRepository;
import ar.edu.unju.fi.arquitectura.tp02.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente crearCliente(Cliente cliente){
        log.info("Creando nuevo cliente por cuil: {}", cliente.getCuil());
        if (clienteRepository.existsByCuilOrEmail(cliente.getCuil(), cliente.getEmail())){
            log.info("No se pudo crear cliente. El CUIL {} o email {} ya está asociado a una cuenta en servicio.", cliente.getCuil(), cliente.getEmail());
            throw new IllegalArgumentException("No se pudo crear la cuenta correctamente. Ya existe en el sistema.");
        }
        Cliente clienteNuevo= clienteRepository.save(cliente);
        log.info("Cliente creado correctamente.");
        return clienteNuevo;
    }

    @Override
    @Transactional
    public Cliente getByCuil(Integer cuil){
        log.info("Buscando cliente con CUIL: {}", cuil);
        return clienteRepository.findByCuil(cuil).orElseThrow(()-> new IllegalArgumentException("Cliente no encontrado."));
    }

    @Override
    @Transactional
    public List<Cliente> listClientes(){
        log.info("Mostrando listado total de clientes.");
        return clienteRepository.findAll();
    }

    @Override
    @Transactional
    public Cliente updateCliente(Integer cuil, Cliente cambios){
        log.info("Actualizando datos de cliente");
        Cliente cliente= clienteRepository.findByCuil(cuil).orElseThrow(()->new IllegalArgumentException("Cliente no registrado"));
        cliente.setNombre(cambios.getNombre());
        cliente.setCuentas(cambios.getCuentas());
        cliente.setCuil(cambios.getCuil());
        cliente.setDireccion(cambios.getDireccion());
        cliente.setTelefono(cambios.getTelefono());
        cliente.setEmail(cambios.getEmail());
        log.info("Datos actualizados correctamente.");
        return clienteRepository.save(cliente);
    }


}
