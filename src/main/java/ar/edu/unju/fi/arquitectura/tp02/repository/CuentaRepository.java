package ar.edu.unju.fi.arquitectura.tp02.repository;

import ar.edu.unju.fi.arquitectura.tp02.model.CajaAhorro;
import ar.edu.unju.fi.arquitectura.tp02.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    Optional<Cuenta> findByAlias(String alias);
    Optional<Cuenta> findByCbu(Integer cbu);
    boolean existsByCbuOrAlias(Integer cbu, String alias);
}
