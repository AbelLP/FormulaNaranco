package org.pspr.entrega_formula.service;

import org.pspr.entrega_formula.model.Resultado;

import java.util.List;
import java.util.Optional;

public interface ResultadoService {
    List<Resultado> findAllResultados();
    Optional<Resultado> findResultadoByPilotoId(Long id);
    Optional<Resultado> findResultadoByCircuitoId(Long id);
}
