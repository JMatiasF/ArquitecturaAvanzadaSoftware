package ar.edu.unju.fi.arquitectura.tp02.repository;

import ar.edu.unju.fi.arquitectura.tp02.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByCuil(Integer cuil);
    Optional<Cliente> findByEmail(String email);
    Boolean existsByCuilOrEmail(Integer cuil, String email);
}
