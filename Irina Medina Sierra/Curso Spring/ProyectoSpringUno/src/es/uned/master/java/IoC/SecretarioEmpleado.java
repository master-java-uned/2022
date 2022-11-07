package es.uned.master.java.IoC;

public class SecretarioEmpleado implements Empleados {
	private String email;
	private String nombreEmpresa;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTarea() {
		// TODO Auto-generated method stub
		return "Gestionar la Agenda de los Jefes";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informer generado por el Secretario: "+informeNuevo.getInforme();
	}
	
	private CreacionInformes informeNuevo;

	public CreacionInformes getInformeNuevo() {
		return informeNuevo;
	}

	public void setInformeNuevo(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}


}
