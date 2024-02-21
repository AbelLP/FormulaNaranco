package org.pspr.entrega_formula.serviceImpl;

import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.repository.PilotoRepo;
import org.pspr.entrega_formula.service.PilotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotoServiceImpl implements PilotosService {

    @Autowired
    private PilotoRepo pilotosRepo;

    @Override
    public List<Piloto> findAllPilotos(){
        return pilotosRepo.findAll();
    }

    @Override
    public Optional<Piloto> findPilotoById(Long id){
        return pilotosRepo.findPilotoById(id);
    }

    @Override
    public List<Piloto> pilotosAleatorios(){
        int n=(int)(Math.random()*21+1);
        return pilotosRepo.pilotosAleatorios(n);
    }

    @Override
    public List<Piloto> findPilotoByEquipo(String equipo){
        return pilotosRepo.findPilotoByEquipo(equipo);
    }

    @Override
    public Piloto savePiloto(Piloto nuevoPiloto){
        if(nuevoPiloto!=null){
            return pilotosRepo.save(nuevoPiloto);
        }
        return null;
    }

    @Override
    public boolean deletePilto(Long id) {
        Optional<Piloto> piloto = pilotosRepo.findById(id);
        if (piloto.isPresent()) {
            pilotosRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Piloto updatePiloto(Piloto pilotoModificado) {
        if (pilotosRepo.existsById(pilotoModificado.getPilotoId())) {
            return pilotosRepo.save(pilotoModificado);
        }
        return null;
    }
}
