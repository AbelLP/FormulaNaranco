package org.pspr.entrega_formula.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Equipo implements Comparable<Equipo>{

    @Getter
    private String nombre;

    @Getter
    private int puntos;

    public Equipo(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int addPuntos(int posicion){
        int punto=0;
        switch (posicion){
            case 1->punto=25;
            case 2->punto=18;
            case 3->punto=15;
            case 4->punto=12;
            case 5->punto=10;
            case 6->punto=8;
            case 7->punto=6;
            case 8->punto=4;
            case 9->punto=2;
            case 10->punto=1;
        }
        return punto;
    }

    @Override
    public int compareTo(Equipo o) {
        return o.puntos-this.puntos;
    }
}
