package clientes;

public class Cliente {

    /**
     * Atributos de clase (nombre, fecha de alta, NIF y su consumo en el último año)
     */

    private String nombre;
    private String idNac;
    private double consumo;

    /**
     * Métodos constructores de clase (sobrecarga)
     * @param nombre
     * @param fechaAlta
     * @param idNac
     * @param consumo
     */

    public Cliente(String nombre, String idNac, double consumo){
        this.nombre=nombre;
        this.idNac=idNac;
        this.consumo=consumo;
    }

    /**
     * Método constructor en el caso de que el cliente no haya consumido
     */
    public Cliente (String nombre, String idNac){
        this.nombre=nombre;
        this.idNac=idNac;
    }

    /**
     * Métodos getter y setter #Construidos por defecto en IntelliJ con ⌘N en IntelliJ#
     * @return nombre, fechaAlta, idNac, consumo
     */
    public String getNombre() {
        return nombre;
    }

    public String getIdNac() {
        return idNac;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdNac(String idNac) {
        this.idNac = idNac;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

}
