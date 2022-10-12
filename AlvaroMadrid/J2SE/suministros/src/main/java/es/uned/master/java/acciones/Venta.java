package es.uned.master.java.acciones;

import es.uned.master.java.caracteristicas.Categoria;

import java.time.LocalDate;

public class Venta {

    private Categoria categ;
    private LocalDate fechaVenta;
    private double importeVenta;

    public Venta(Categoria categ, LocalDate fechaVenta, double importeVenta) {
        this.categ = categ;
        this.fechaVenta = fechaVenta;
        this.importeVenta = importeVenta;
    }

    public double getImporteVenta(){
        return importeVenta;
    }
}
