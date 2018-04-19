package es.fpdual.hibernate.hibernate_dual.pruebas;

import java.util.Date;
import java.util.List;

import es.fpdual.hibernate.hibernate_dual.Cliente;
import es.fpdual.hibernate.hibernate_dual.EstadoCivil;
import es.fpdual.hibernate.hibernate_dual.Persona;
import es.fpdual.hibernate.hibernate_dual.Vehiculo;
import es.fpdual.hibernate.hibernate_dual.repositorio.RepositorioCliente;
import es.fpdual.hibernate.hibernate_dual.repositorio.RepositorioPersona;
import es.fpdual.hibernate.hibernate_dual.repositorio.RepositorioVehiculo;

public class PruebasCliente {
	
	public static void main(String[] args) {
		final Integer idPersona = crearCliente("68541894Z","jose");
		eliminarCliente(idPersona);
	}

	private static Integer crearCliente(String dni, String login) {
		final Cliente cliente = new Cliente();
		cliente.setNombre("Jose");
		cliente.setApellidos("Marquez Perez");
		cliente.setEdad(20);
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setDni(dni);
		cliente.setFechaAlta(new Date());
		cliente.setLogin(login);
		cliente.setPassword("jose");
		
		return RepositorioCliente.crearCliente(cliente);
	}

	private static void modificarCliente(Integer idCliente) {

		final Cliente cliente = new Cliente();
		cliente.setNombre("Josee");
		cliente.setApellidos("Maarquez Peerez");
		cliente.setEdad(20);
		cliente.setEstadoCivil(EstadoCivil.CON_NOVIA);
		cliente.setDni("31021471X");
		cliente.setFechaAlta(new Date());
		cliente.setLogin("ja");
		cliente.setPassword("ja");
		cliente.setIdUsuario(idCliente);

		RepositorioCliente.modificarCliente(cliente);
	}

	private static void eliminarCliente(final Integer idCliente) {

		RepositorioPersona.eliminarPersona(idCliente);
	}

	private static Integer crearVehiculo() {
		final Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("VolksWagen");
		vehiculo.setModelo("Golf");
		vehiculo.setCilindrada(150);
		vehiculo.setNumPuertas(4);
		vehiculo.setFechaMatriculacion(new Date());
		vehiculo.setColor("Rojo");

		return RepositorioVehiculo.crearVehiculo(vehiculo);
	}

	private static void eliminarVehiculo(Integer idVehiculo) {
		RepositorioVehiculo.eliminarVehiculo(idVehiculo);
	}
	
	private static void consultarCliente(final Integer idCliente) {
		final Cliente cliente = RepositorioCliente.consultarNombreCompleto(idCliente);
		System.out.println(cliente.getNombre());
		System.out.println(cliente.getApellidos());
		System.out.println(cliente.getEstadoCivil());
		System.out.println(cliente.getEdad());
		System.out.println(cliente.getDni());
	}

	private static void consultarCliente(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final List<Cliente> cliente = RepositorioCliente.consultarCliente(nombre, apellidos, dni, estadoCivil, login);
		System.out.println(cliente.size());
	}
}
