package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.model.Resultado;
import org.pspr.entrega_formula.model.ResultadoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ResultadoRepo extends JpaRepository<Resultado, ResultadoId> {

    @Query("SELECT r FROM Resultado r ORDER BY r.circuitos.nombre, r.posicionLlegada")
    List<Resultado> findAll();

    @Query("SELECT r FROM Resultado r WHERE r.piloto.pilotoId=?1 " )
    Optional<Resultado> findResultadoByPilotoId(Long id);

    @Query("SELECT r FROM Resultado r WHERE r.circuitos.circuitoId=?1")
    Optional<Resultado> findResultadoByCircuitos(Long id);

}
