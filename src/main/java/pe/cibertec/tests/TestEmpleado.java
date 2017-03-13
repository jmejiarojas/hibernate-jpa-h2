package pe.cibertec.tests;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pe.cibertec.modelo.Direccion;
import pe.cibertec.modelo.Empleado;

public class TestEmpleado {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Persistencia");

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		//EntityManager manager = factory.createEntityManager();

		Empleado emp1 = new Empleado(1L, "Mejia Rojas", "Julio Edgar", LocalDate.of(1987, 10, 4));
		Empleado emp2 = new Empleado(2L, "Mejias Rojas", "Ju Edgar", LocalDate.of(1987, 10, 4));
		Empleado emp3 = new Empleado(3L, "Mesias Rosas", "Juanjo Edgar", LocalDate.of(1987, 10, 4));
		Empleado emp4 = new Empleado(4L, "Castillo Ore", "Magaly", LocalDate.of(1987, 10, 4));
		
		//Direccion direccion = new Direccion(1L, "calle 123", "Los Olivos", "Lima", "Peru");
		
//		EntityManager manager = factory.createEntityManager();
//		manager.getTransaction().begin();
//		manager.persist(direccion);
//		manager.getTransaction().commit();
		
		emp4.setDireccion(new Direccion(1L, "calle 123", "Los Olivos", "Lima", "Peru"));
		//emp4.setDireccion(direccion);
		
		insertarEmpleado(emp1);
		insertarEmpleado(emp2);
		insertarEmpleado(emp3);
		insertarEmpleado(emp4);

		mostrarEmpleados();

		updateEmpleado();

		mostrarEmpleados();
		
		eliminarEmpleado();
		
		mostrarEmpleados();

		//manager.close();
	}

	private static void eliminarEmpleado() {
		//Eliminamos el empleado3
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Empleado empleado = manager.find(Empleado.class,3L);
		manager.remove(empleado);
		manager.getTransaction().commit();
		manager.close();
	}

	private static void updateEmpleado() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Empleado encontrado = manager.find(Empleado.class, 3L);
		encontrado.setNombres("Jose Luis");
		encontrado.setApellidos("Mejilla Roja");
		manager.getTransaction().commit();
		manager.close();
	}

	private static void insertarEmpleado(Empleado emp) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(emp);
		manager.getTransaction().commit();
		manager.close();
	}

	private static void mostrarEmpleados() {
		EntityManager manager = factory.createEntityManager();
		List<Empleado> empleados = manager.createQuery("from Empleado e").getResultList();
		System.out.println("En esta Bd hay : " + empleados.size() + " empleados");
		empleados.forEach((empleado) -> System.out.println(empleado));
		manager.close();
	}
}
