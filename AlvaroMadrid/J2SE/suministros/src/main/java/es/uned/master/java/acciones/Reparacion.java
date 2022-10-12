package es.uned.master.java.acciones;

import java.time.*;

public class Reparacion {

    private LocalDate fechaInicRep;
    private LocalDate fechaFinRep;
    private double importeRep;

    public Reparacion(LocalDate fechaReparacion, LocalDate fechaFin, double importeRep){
        this.fechaInicRep = fechaReparacion;
        this.fechaFinRep = fechaFin;
        this.importeRep = importeRep;
    }

    public double getImporteRep(){
        return importeRep;
    }

    public LocalDate getFechaInicRep(){
        return fechaInicRep;
    }

    public LocalDate getFechaFinRep(){
        return fechaFinRep;
    }

}
