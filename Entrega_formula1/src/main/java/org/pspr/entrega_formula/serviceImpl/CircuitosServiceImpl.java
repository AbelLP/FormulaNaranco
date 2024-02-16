package org.pspr.entrega_formula.serviceImpl;

import org.pspr.entrega_formula.model.Circuitos;
import org.pspr.entrega_formula.repository.CircuitosRepo;
import org.pspr.entrega_formula.service.CircuitosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitosServiceImpl implements CircuitosService {

    @Autowired
    private CircuitosRepo circuitosRepo;

    @Override
    public List<Circuitos> findAllCircuitos() {
        return circuitosRepo.findAll();
    }

    @Override
    public Optional<Circuitos> findCircuitoById(Long circuitoId) {
        return circuitosRepo.findCircuitosById(circuitoId);
    }

    @Override
    public Circuitos saveCircuito(Circuitos nuevoCircuito) {
        if(nuevoCircuito!=null){
            return circuitosRepo.save(nuevoCircuito);
        }
        return null;
    }

    @Override
    public boolean deleteCircuito(Long circuitoId) {
        Optional<Circuitos> circuitos = circuitosRepo.findCircuitosById(circuitoId);
        if (circuitos.isPresent()) {
            circuitosRepo.deleteById(circuitoId);
            return true;
        }
        return false;
    }

    @Override
    public Circuitos updateCircuitos(Circuitos circuitoModificado) {
        if (circuitosRepo.existsById(circuitoModificado.getCircuitoId())) {
            return circuitosRepo.save(circuitoModificado);
        }
        return null;
    }


}
