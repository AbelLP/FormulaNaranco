package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.model.Circuitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CircuitosRepo extends JpaRepository<Circuitos, Long> {

    @Query("SELECT c FROM Circuitos c WHERE c.circuitoId=?1")
    Optional<Circuitos> findCircuitosById(Long circuitosId);
}
