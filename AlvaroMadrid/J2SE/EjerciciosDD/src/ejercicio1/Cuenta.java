package ejercicio1;

public class Cuenta {

    // Atributos de la clase
    private String titular;
    private double cantidad;

    // Métodos constructores de clase
    public Cuenta(String titular, double cantidad){
        this.titular = titular;
        // Si la cantidad es menor que cero, lo ponemos a cero
        if(cantidad < 0){
            this.cantidad = 0;
        } else {
            this.cantidad = cantidad;
        }
    }
    public Cuenta(String titular){
        this(titular, 0); // Sobrecarga del método constructor
    }

    // Métodos get, set y toString
    public String getTitular(){
        return titular;
    }
    public void setTitular(String titular){
        this.titular = titular;
    }

    public double getCantidad(){
        return cantidad;
    }
    public void setCantidad(double cantidad){
        this.cantidad = cantidad;
    }

    /**
     * Ingresa dinero en la cuenta,
     * solo si la cantidad es positiva
     *
     * @param cantidad
     */

    public void ingresar(double cantidad){
        if(cantidad>0){
            this.cantidad += cantidad;
        }
    }

    /**
     * Retira una cantidad en la cuenta, si se quedara en negativo se quedaria
     * en cero
     *
     * @param cantidad
     */

    public void retirar(double cantidad){
        if(this.cantidad - cantidad < 0 ){
            this.cantidad = 0;
        } else {
            this.cantidad -= cantidad;
        }
    }

    /**
     * Devuelve el estado del objeto
     *
     * @return
     */

    public String toString(){
        return "El titular " + titular + " tiene " + cantidad + " euros en la cuenta";
    }

}
