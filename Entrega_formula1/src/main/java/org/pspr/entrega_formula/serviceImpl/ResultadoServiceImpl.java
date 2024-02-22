package org.pspr.entrega_formula.serviceImpl;

import org.pspr.entrega_formula.model.Resultado;
import org.pspr.entrega_formula.repository.ResultadoRepo;
import org.pspr.entrega_formula.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoServiceImpl implements ResultadoService {

    @Autowired
    private ResultadoRepo resultadoRepo;

    @Override
    public List<Resultado> findAllResultados() {
        return resultadoRepo.findAll();
    }

    @Override
    public List<Resultado> findResultadoByCadena(String cadena){
        return resultadoRepo.findResultadoByCadena("%"+cadena+"%");
    }

    @Override
    public List<Resultado> findResultadoByNombre(String nombre){
        return resultadoRepo.findResultadoByNombre(nombre);
    }

}