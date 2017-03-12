package pe.cibertec.tests;

import java.util.GregorianCalendar;
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
		
		Empleado emp1 = new Empleado(1L, "Mejia Rojas", "Julio Edgar", new GregorianCalendar(1987,10,10).getTime());
		Empleado emp2 = new Empleado(2L, "Mejias Rojas", "Ju Edgar", new GregorianCalendar(1987,10,10).getTime());
		
		insertarEmpleado(emp1, emp2);
		
		List<Empleado> empleados = manager.createQuery("from Empleado e").getResultList();
		mostrarEmpleados(empleados);
		
	}

	private static void insertarEmpleado(Empleado emp1, Empleado emp2) {
		manager.getTransaction().begin();
		manager.persist(emp1);
		manager.persist(emp2);
		manager.getTransaction().commit();
//		manager.close();
	}

	private static void mostrarEmpleados(List<Empleado> empleados) {
		System.out.println("En esta Bd hay : " +empleados.size() + " empleados");
		empleados.forEach((empleado) -> System.out.println(empleado));
	}
}
