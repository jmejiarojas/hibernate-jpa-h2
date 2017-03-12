package pe.cibertec.tests;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pe.cibertec.modelo.Empleado;

public class TestEmpleado {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Persistencia");
	private static EntityManager manager;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		manager = factory.createEntityManager();

		Empleado emp1 = new Empleado(1L, "Mejia Rojas", "Julio Edgar", new GregorianCalendar(1987, 10, 10).getTime());
		Empleado emp2 = new Empleado(2L, "Mejias Rojas", "Ju Edgar", new GregorianCalendar(1987, 10, 10).getTime());
		Empleado emp3 = new Empleado(3L, "Mesias Rosas", "Juanjo Edgar", new GregorianCalendar(1987, 10, 10).getTime());

		insertarEmpleado(emp1);
		insertarEmpleado(emp2);
		insertarEmpleado(emp3);

		mostrarEmpleados();

		updateEmpleado();

		mostrarEmpleados();

		manager.close();
	}

	private static void updateEmpleado() {
		manager.getTransaction().begin();
		Empleado encontrado = manager.find(Empleado.class, 3L);
		encontrado.setNombres("Jose Luis");
		encontrado.setApellidos("Mejilla Roja");
		manager.getTransaction().commit();
	}

	private static void insertarEmpleado(Empleado emp) {
		manager.getTransaction().begin();
		manager.persist(emp);
		manager.getTransaction().commit();
		//manager.close();
	}

	private static void mostrarEmpleados() {
		List<Empleado> empleados = manager.createQuery("from Empleado e").getResultList();
		System.out.println("En esta Bd hay : " + empleados.size() + " empleados");
		empleados.forEach((empleado) -> System.out.println(empleado));
	}
}
