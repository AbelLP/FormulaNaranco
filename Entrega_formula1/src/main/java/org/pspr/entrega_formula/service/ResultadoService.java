package org.pspr.entrega_formula.service;

import org.pspr.entrega_formula.model.Resultado;

import java.util.List;
import java.util.Optional;

public interface ResultadoService {
    List<Resultado> findAllResultados();

    List<Resultado> findResultadoByCadena(String cadena);

    List<Resultado> findResultadoByNombre(String nombre);
}
