package es.uned.master.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.uned.master.java.beans.AppConfig;
import es.uned.master.java.beans.Mundo;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ApplicationContext appContext=new ClassPathXmlApplicationContext("es/uned/master/java/xml/beans.xml");
		ApplicationContext appContext=new AnnotationConfigApplicationContext(AppConfig.class);
		Mundo n=(Mundo) appContext.getBean("mundo");
		
		
		System.out.println(n.getSaludo());
		((ConfigurableApplicationContext)appContext).close();
	}

}
