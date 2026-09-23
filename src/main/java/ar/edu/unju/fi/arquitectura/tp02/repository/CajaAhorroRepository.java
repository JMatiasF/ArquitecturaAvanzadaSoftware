package ar.edu.unju.fi.arquitectura.tp02.repository;

import ar.edu.unju.fi.arquitectura.tp02.model.CajaAhorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CajaAhorroRepository extends JpaRepository<CajaAhorro, Integer> {

}
