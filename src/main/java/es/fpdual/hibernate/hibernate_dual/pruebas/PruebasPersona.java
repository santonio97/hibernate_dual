package es.fpdual.hibernate.hibernate_dual.pruebas;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import es.fpdual.hibernate.hibernate_dual.Cliente;
import es.fpdual.hibernate.hibernate_dual.Direccion;
import es.fpdual.hibernate.hibernate_dual.EstadoCivil;
import es.fpdual.hibernate.hibernate_dual.Persona;
import es.fpdual.hibernate.hibernate_dual.Vehiculo;
import es.fpdual.hibernate.hibernate_dual.repositorio.RepositorioPersona;
import es.fpdual.hibernate.hibernate_dual.repositorio.RepositorioVehiculo;

public class PruebasPersona {

	public static void main(String[] args) {
		final Integer idPersona = crearPersona("68541894Z","jose");
		modificarPersona(idPersona);
		
		
	}

	private static Integer crearPersona(String dni, String login) {
		final Persona persona = new Persona();
		persona.setNombre("Jose");
		persona.setApellidos("Marquez Perez");
		persona.setEdad(20);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("jose");
		
		final Direccion direccion1 = new Direccion();
		direccion1.setProvincia("Sevilla");
		direccion1.setCiudad("Ecija");
		direccion1.setCodPostal("41400");
		direccion1.setDireccion("c/barcelona");
		direccion1.setNumero(1);
		direccion1.setPersonas(Arrays.asList(persona));

		final Direccion direccion2 = new Direccion();
		direccion2.setProvincia("Sevilla");
		direccion2.setCiudad("Ecija");
		direccion2.setCodPostal("41401");
		direccion2.setDireccion("c/barcelona");
		direccion2.setNumero(1);
		direccion2.setPersonas(Arrays.asList(persona));
		
		persona.setDirecciones(null);
		return RepositorioPersona.crearPersona(persona);
	}
	
	private static void modificarDireccion(Integer idPersona) {
		
	}
	
	private static void modificarPersona(Integer idPersona) {

		final Persona persona = new Persona();
		persona.setNombre("Josee");
		persona.setApellidos("Maarquez Peerez");
		persona.setEdad(20);
		persona.setEstadoCivil(EstadoCivil.CON_NOVIA);
		persona.setDni("31021471X");
		//persona.setIdPersona(2);

		RepositorioPersona.modificarPersona(persona);
	}

	private static void eliminarPersona(final Integer idPersona) {

		RepositorioPersona.eliminarPersona(idPersona);
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
	
	private static void consultarPersona(final Integer idPersona) {
		final Persona persona = RepositorioPersona.consultarNombreCompleto(idPersona);
		System.out.println(persona.getNombre());
		System.out.println(persona.getApellidos());
		System.out.println(persona.getEstadoCivil());
		System.out.println(persona.getEdad());
		System.out.println(persona.getDni());
	}

	private static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final List<Persona> personas = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil, login);
		System.out.println(personas.size());
	}

}
