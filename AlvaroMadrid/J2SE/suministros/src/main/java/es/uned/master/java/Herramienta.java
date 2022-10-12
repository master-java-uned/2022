package es.uned.master.java;

import es.uned.master.java.acciones.Alquiler;
import es.uned.master.java.acciones.Reparacion;
import es.uned.master.java.acciones.Venta;
import es.uned.master.java.caracteristicas.Categoria;
import es.uned.master.java.caracteristicas.Estado;
import es.uned.master.java.caracteristicas.NumeroDeReferencia;

import java.time.LocalDate;

public class Herramienta {

    private String referencia;
    private NumeroDeReferencia nRef;
    private Categoria categoria;
    private Estado estado;
    private LocalDate fechaAdquisicion;

    private Alquiler alquileres;
    private Reparacion reparaciones;
    private Venta venta;


    public Herramienta(Categoria categoria, Estado estado, LocalDate fechaAdquisicion) {
        this.categoria = categoria;
        this.estado = estado;
        this.fechaAdquisicion = fechaAdquisicion;

        nRef = new NumeroDeReferencia(categoria);
    }

    public String getCategoria(){
        return categoria.toString();
    }

    public String getEstado(){
        return estado.toString();
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public LocalDate getFechaAdquisicion(){
        return fechaAdquisicion;
    }

    public String getNumeroDeReferencia(){
        return nRef.toString();
    }

    public double getPrecioVenta(){
        double precioVendido = getPrecioVenta();
        return precioVendido;
    }

    @Override
    public String toString(){
        return nRef + " | " + estado + " | " + fechaAdquisicion;
    }

}

