package es.uned.master.java.acciones;

import es.uned.master.java.caracteristicas.Categoria;

import java.time.*;

import static es.uned.master.java.caracteristicas.Categoria.*;

public class Alquiler {

    private Categoria categ;
    private LocalDate fechaInicAlq;
    private LocalDate fechaFinAlq;

    private double importeAlq;
    private int duracionAlq;

    /*
    @In @Out @Err

     */


    public Alquiler(Categoria categ, LocalDate fechaInicAlq, LocalDate fechaFinAlq){
        this.categ = categ;
        this.fechaInicAlq = fechaInicAlq;
        this.fechaFinAlq = fechaFinAlq;

        duracionAlq = Period.between(fechaInicAlq, fechaFinAlq).getDays();
        switch (categ){
            case LIMPIEZA:
                importeAlq = LIMPIEZA.getAlquiler() * duracionAlq;
                break;

            case OBRA:
                importeAlq = OBRA.getAlquiler() * duracionAlq;
                break;

            case PINTURA:
                importeAlq = PINTURA.getAlquiler() * duracionAlq;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + categ);
        }

    }

    public double getPrecioAlquiler(){
        return importeAlq;
    }

    public LocalDate getFechaInicAlq(){
        return fechaInicAlq;
    }

    public LocalDate getFechaFinAlq(){
        return fechaFinAlq;
    }

    public int getDuracionAlq(){
        return duracionAlq;
    }

    public String getCategAlq(){
        return categ.toString();
    }

}
