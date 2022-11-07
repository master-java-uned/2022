package es.uned.master.java.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creación de Objetos de tipo Empleado
		/*
		Empleados Empleado1=new JefeEmpleado();
		
		//Uso de los objetos empleados
		System.out.println(Empleado1.getTarea());*/
		
		//1. Crear un contexto
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext ("applicationContext.xml");
		
		
		// Empleados Juan=contexto.getBean("miEmpleado",Empleados.class);
		
		//System.out.println(Juan.getTarea());
		//System.out.println(Juan.getInforme());
		
		
		//Empleados Maria=contexto.getBean("miSecretarioEmpleado", Empleados.class);
		
		
		SecretarioEmpleado Maria=contexto.getBean("miSecretarioEmpleado",SecretarioEmpleado.class);
		
		System.out.println(Maria.getTarea());
		System.out.println(Maria.getInforme());
		System.out.println("Email: "+ Maria.getEmail());
		System.out.println("Empresa: "+ Maria.getNombreEmpresa());

		contexto.close();
	}

}
