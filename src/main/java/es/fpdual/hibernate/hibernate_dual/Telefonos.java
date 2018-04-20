package es.fpdual.hibernate.hibernate_dual;

import javax.persistence.*;

@Table
@Entity(name = "Telefono")
public class Telefonos {

	@Id
	@GeneratedValue
	@Column(name = "TLF_ID")
	@SequenceGenerator(name = "sequence-generator", sequenceName = "product_sequence", initialValue = 69, allocationSize = 100)
	private Integer idTlf;

	@Column(name = "TLF_NUM", nullable = false)
	private String numero;

	@ManyToOne
	@JoinColumn(name = "PER_ID", foreignKey = @ForeignKey(name = "PER_ID_FK"))
	private Persona persona;

	public Telefonos() {

	}

	public Telefonos(String numero) {
		this.numero = numero;
	}

	public Integer getIdTlf() {
		return idTlf;
	}

	public void setIdTlf(Integer idTlf) {
		this.idTlf = idTlf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
