package es.fpdual.hibernate.hibernate_dual;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "A_AFI")
public class Aficion {

	@Id
	@GeneratedValue
	@Column(name = "AFI_ID")
	private int idAficion;

	@Column(name = "AFI_NOM", nullable = false)
	private String nombreAficion;

	@ManyToMany(mappedBy = "aficiones")
	private List<Persona> personas;

	public Aficion() {

	}

	public int getIdAficion() {
		return idAficion;
	}

	public void setIdAficion(int idAficion) {
		this.idAficion = idAficion;
	}

	public String getAficion() {
		return nombreAficion;
	}

	public void setAficion(String nombreAficion) {
		this.nombreAficion = nombreAficion;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}
