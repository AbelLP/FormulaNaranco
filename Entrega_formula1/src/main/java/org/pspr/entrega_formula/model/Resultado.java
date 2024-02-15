package org.pspr.entrega_formula.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

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
