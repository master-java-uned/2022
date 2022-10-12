package es.uned.master.java.caracteristicas;

// Creamos una clase Enum con las tres categorías posibles
public enum Categoria {
    LIMPIEZA(10,50), OBRA(15,75), PINTURA(12,100);

    // Declaramos los atributos de la clase Enum (alquiler, venta)
    private int alquiler;
    private int venta;

    // Constructor de clase
    private Categoria(int alquiler, int venta) {
        this.alquiler = alquiler;
        this.venta = venta;
    }

    // Método getter del atributo Alquiler
    public int getAlquiler() {
        return alquiler;
    }

    // Método getter del atributo venta
    public int getVenta() {
        return venta;
    }

    // Método setter del atributo alquiler
    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    // Método setter del atributo venta
    public void setVenta(int venta) {
        this.venta = venta;
    }
}

