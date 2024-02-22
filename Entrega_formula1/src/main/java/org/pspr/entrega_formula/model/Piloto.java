package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pilotos")
@Getter @Setter
@NoArgsConstructor
public class Piloto implements Comparable<Piloto>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pilotoId;

    private int numero;
    private String equipo;
    private String foto;
    private String nombre;

    @Transient
    private int puntos;

    @Override
    public int compareTo(Piloto o) {
        return o.puntos-this.puntos;
    }



}
