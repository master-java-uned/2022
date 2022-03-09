package es.uned.master.java.enumerados;

public enum Categoria {
    LIMPIEZA(10,50), OBRA(15,75), PINTURA(12,100);

    private int alquiler;
    private int venta;

    private Categoria(int alquiler, int venta) {
        this.alquiler = alquiler;
        this.venta = venta;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public int getVenta() {
        return venta;
    }
    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }
}
