package org.pspr.entrega_formula.service;

import org.pspr.entrega_formula.model.Circuitos;

import java.util.List;
import java.util.Optional;

public interface CircuitosService {
    List<Circuitos> findAllCircuitos();
    Optional<Circuitos> findCircuitoById(Long circuitoId);
    Circuitos saveCircuito(Circuitos nuevoCircuito);
    boolean deleteCircuito(Long id);
    Circuitos updateCircuitos(Circuitos circuitoModificado);
}
