package es.uned.master.java.IoC;

public class DirectorEmpleado implements Empleados {
	
	//Creación campo de tipo CreacionInforme(interfaz) que inyecta la dependencia
	
	private CreacionInformes informeNuevo;
	
	// creacion del constructor que inyecta la dependencia
	public DirectorEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo=informeNuevo;
	}
	

	public String getTarea() {
		// TODO Auto-generated method stub
		return "Gestionar la plantilla de la empresa";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe creado por el Director: "+informeNuevo.getInforme();
	}

	
}