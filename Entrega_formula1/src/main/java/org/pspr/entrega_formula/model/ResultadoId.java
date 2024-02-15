package org.pspr.entrega_formula.model;

import jakarta.persistence.Column;

import java.io.Serializable;

public class ResultadoId implements Serializable {

    @Column(name="circuitoId")
    private Long circuitoId;

    @Column(name="pilotoId")
    private Long pilotoId;

}
