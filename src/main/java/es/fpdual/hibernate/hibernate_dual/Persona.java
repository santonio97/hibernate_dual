package es.fpdual.hibernate.hibernate_dual;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "A_PER")
public class Persona extends Usuario {

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;
	
	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDAD", nullable = false)
	private Integer edad;
	
	@Column(name = "PER_ECV", nullable = false)
	@Enumerated
	private EstadoCivil estadoCivil;

	@Column(name = "PER_DIR", nullable = false)
	private List<Persona> direccion;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Direccion> direcciones;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "persona")
	private Set<Telefonos> telefonos;

	//constructor vacio
	public Persona() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<Persona> getDirecciones() {
		return direccion;
	}

	public void setDirecciones(List<Persona> direccion) {
		this.direccion = direccion;
	}
	
}
