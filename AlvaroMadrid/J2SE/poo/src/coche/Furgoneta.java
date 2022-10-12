package coche;

public class Furgoneta extends Coche{
    // EXTENDS convierte a Coche en una superclase(padre), y Furgoneta una subclase(hijo)
    // Para saber si el diseño de herencia tiene sentido, debe preguntarse "es un..."
    // Furgoneta no es un coche, por lo que el diseño debería haber sido Vehiculo como superclase

    private int capacidad_carga;
    private int plazas_extra;

    public Furgoneta(int plazas_extra, int capacidad_carga){

        super(); // Llamar al constructor de la superclase(padre)
        this.capacidad_carga = capacidad_carga;
        this.plazas_extra = plazas_extra;

    }

    public String dimeDatosFurgoneta(){
        return "La capacidad de carga es " + capacidad_carga + " y las plazas con " + plazas_extra;
    }



}
