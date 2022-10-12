package colecciones;

    public class Cliente {

        public Cliente (String nombre, String n_cuenta, double saldo){
            this.nombre=nombre;
            this.n_cuenta=n_cuenta;
            this.saldo=saldo;
        }

        private String nombre;
        private String n_cuenta;
        private double saldo;

        // Métodos getter y setter

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getN_cuenta() {
            return n_cuenta;
        }

        public void setN_cuenta(String n_cuenta) {
            this.n_cuenta = n_cuenta;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }
    }

}
