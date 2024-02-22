package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.dto.PilotoDTO;
import org.pspr.entrega_formula.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PilotoRepo extends JpaRepository<Piloto, Long> {

    @Query("SELECT p FROM Piloto p WHERE p.pilotoId=?1")
    Optional<Piloto> findPilotoById(Long id);

    @Query("SELECT p FROM Piloto p WHERE p.pilotoId=?1")
    Piloto findPilotoById2(Long id);

    @Query("SELECT p FROM Piloto p WHERE p.numero BETWEEN :n AND :n+2")
    List<Piloto> pilotosAleatorios(int n);

    @Query("SELECT p FROM Piloto p WHERE p.equipo ='equipo'")
    List<Piloto> findPilotoByEquipo(String equipo);

    @Query("SELECT new org.pspr.entrega_formula.dto.PilotoDTO (p, count (*)) FROM Resultado r JOIN Piloto p ON r.piloto.pilotoId=p.pilotoId WHERE r.posicionLlegada=1 GROUP BY r.piloto.pilotoId, p.nombre ORDER BY COUNT(*) DESC LIMIT 1")
    PilotoDTO findPilotoByVictorias();


}
