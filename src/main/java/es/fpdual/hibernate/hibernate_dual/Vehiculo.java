package es.fpdual.hibernate.hibernate_dual;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "A_VEH")
public class Vehiculo implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "VEH_ID")
	private int idVehiculo;

	@Column(name = "VEH_MCA", nullable = false, length = 50)
	private String marca;

	@Column(name = "VEH_MOD", nullable = false, length = 50)
	private String modelo;

	@Column(name = "VEH_CV", nullable = false, length = 50)
	private Integer cilindrada;

	@Column(name = "VEH_PTAS", nullable = false)
	private Integer numPuertas;

	@Column(name = "VEH_FEC", nullable = false)
	private Date fechaMatriculacion;

	@Column(name = "VEH_COL", nullable = false, length = 15)
	private String color;

	// constructor vacio
	public Vehiculo() {

	}

	// GETTERS
	public int getIdVehiculo() {
		return idVehiculo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getCilindrada() {
		return cilindrada;
	}

	public Integer getNumPuertas() {
		return numPuertas;
	}

	public Date getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public String getColor() {
		return color;
	}

	// SETTERS
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setCilindrada(Integer cilindrada) {
		this.cilindrada = cilindrada;
	}

	public void setNumPuertas(Integer numPuertas) {
		this.numPuertas = numPuertas;
	}

	public void setFechaMatriculacion(Date fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public void setColor(String color) {
		this.color = color;
	}
}