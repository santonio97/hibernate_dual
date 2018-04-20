package es.fpdual.hibernate.hibernate_dual;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity(name = "Direccion")
public class Direccion implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "DIR_ID")
	private Integer idDireccion;

	@Column(name = "DIR_PRO", nullable = false)
	private String provincia;

	@Column(name = "DIR_CIU", nullable = false)
	private String ciudad;

	@Column(name = "DIR_COD", nullable = false, unique = true)
	private String codPostal;

	@Column(name = "DIR_CAL", nullable = false)
	private String calle;

	@Column(name = "DIR_NUM", nullable = false)
	private Integer numero;

	@Column(name = "DIR_BLOQ", nullable = false)
	private Integer bloque;

	@Column(name = "DIR_PLA", nullable = false)
	private Integer planta;

	@Column(name = "DIR_PTA", nullable = false)
	private String puerta;

	@Column(name = "DIR_PER", nullable = false)
	private List<Direccion> persona;

	@Column(name = "DIR_DIR", nullable = false)
	private String direccion;

	// CONSTRUCTOR VACIO
	public Direccion() {

	}

	// GETTERS Y SETTERS
	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Direccion> getPersonas() {
		return persona;
	}

	public void setPersonas(List<Direccion> personas) {
		this.persona = persona;
	}

	// FIN DE GETTERS Y SETTERS

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Direccion dir = (Direccion) o;
		return Objects.equals(calle, dir.calle) && Objects.equals(numero, dir.numero)
				&& Objects.equals(codPostal, dir.codPostal);
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, numero, codPostal);
	}
}