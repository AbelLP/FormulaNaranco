package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="circuitos")
@Getter
@Setter
@NoArgsConstructor
public class Circuitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long circuitoId;

    private double longitud;
    private int numeroCurvas;
    private int numeroVueltas;
    private String nombre;
    private String foto;
    private String pais;

}
