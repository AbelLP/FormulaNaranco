package org.pspr.entrega_formula.service;

import org.pspr.entrega_formula.dto.PilotoDTO;
import org.pspr.entrega_formula.model.Piloto;

import java.util.List;
import java.util.Optional;

public interface PilotosService {
    List<Piloto> findAllPilotos();
    Optional<Piloto> findPilotoById(Long id);

    Piloto findPilotoById2(Long id);

    List<Piloto> pilotosAleatorios();
    List<Piloto> findPilotoByEquipo(String equipo);
    PilotoDTO findPilotoByVictorias();
    Piloto savePiloto(Piloto nuevoPiloto);
    boolean deletePilto(Long id);
    Piloto updatePiloto(Piloto pilotoModificado);

}
