package pe.cibertec.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pe.cibertec.modelo.Empleado;

public class TestEmpleado {
	
	private static EntityManagerFactory factory;
	private  static EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		factory = Persistence.createEntityManagerFactory("Persistencia");
		manager = factory.createEntityManager();
		
		List<Empleado> empleados = manager.createQuery("from Empleado e").getResultList();
		
		System.out.println("En esta Bd hay : " +empleados.size() + " empleados");
		empleados.forEach((empleado) -> System.out.println(empleado));
		
	}
}
