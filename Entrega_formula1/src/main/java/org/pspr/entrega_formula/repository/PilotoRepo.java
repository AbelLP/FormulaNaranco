package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PilotoRepo extends JpaRepository<Piloto, Long> {

    @Query("SELECT p FROM Piloto p WHERE p.pilotoId=?1")
    Optional<Piloto> findPilotoById(Long id);

    @Query("SELECT p FROM Piloto p WHERE p.numero BETWEEN :n AND :n+2")
    List<Piloto> pilotosAleatorios(int n);


}
