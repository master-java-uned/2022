package es.uned.master.java.caracteristicas;

// Creamos una clase Enum con los tres estados de cada herramienta
public enum Estado {
    DISPONIBLE("DISPONIBLE"), ALQUILADO("ALQUILADO"), ENREPARACION("ENREPARACION"), VENDIDO("VENDIDO");

    private final String estado;

    Estado(final String estado) {
        this.estado = estado;
    }

    public String getEstado(){
        return estado;
    }
}
