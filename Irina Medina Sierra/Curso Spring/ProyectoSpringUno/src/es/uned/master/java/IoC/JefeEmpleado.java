package es.uned.master.java.IoC;

public class JefeEmpleado implements Empleados {
	
	public JefeEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	private CreacionInformes informeNuevo;
	
	public String getTarea() {
		return "Gestionar las cuestiones relativas a los empleados de la sección";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe generado por el Jefe: "+informeNuevo.getInforme();
	}


}
