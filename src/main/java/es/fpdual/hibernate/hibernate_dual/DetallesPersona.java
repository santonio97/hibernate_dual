package es.fpdual.hibernate.hibernate_dual;

import javax.persistence.*;

@Entity
@Table(name = "DetallesPersona")
public class DetallesPersona {

	@Id
	@GeneratedValue
	@Column(name = "DTL_ID")
	private int idDetPer;
	
	@Column(name = "DTL_DEP", nullable = false)
	private Boolean gustaDeporte;
	
	@Column(name = "DTL_MSC", nullable = false)
	private Boolean tieneMascotas;
	
	@Column(name = "DTL_HIJ", nullable = false)
	private Boolean tieneHijos;
	
	// CONSTRUCTOR VACIO
	public DetallesPersona() {
		
	}
	
	// GETTERS Y SETTERS

	public int getIdDetPer() {
		return idDetPer;
	}

	public void setIdDetPer(int idDetPer) {
		this.idDetPer = idDetPer;
	}

	public Boolean getGustaDeporte() {
		return gustaDeporte;
	}

	public void setGustaDeporte(Boolean gustaDeporte) {
		this.gustaDeporte = gustaDeporte;
	}

	public Boolean getTieneMascotas() {
		return tieneMascotas;
	}

	public void setTieneMascotas(Boolean tieneMascotas) {
		this.tieneMascotas = tieneMascotas;
	}

	public Boolean getTieneHijos() {
		return tieneHijos;
	}

	public void setTieneHijos(Boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}
		
}
