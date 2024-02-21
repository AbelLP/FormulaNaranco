package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="resultados")
@Getter
@Setter
@NoArgsConstructor
public class Resultado {

    @EmbeddedId
    private ResultadoId resultadoId;


    private int posicionSalida;
    private int posicionLlegada;

    @ManyToOne
    @MapsId("pilotoId")
    @JoinColumn(name="pilotoId")
    private Piloto piloto;

    @ManyToOne
    @MapsId("circuitoId")
    @JoinColumn(name="circuitoId")
    private Circuitos circuitos;
}
