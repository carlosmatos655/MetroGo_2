package pe.metrogo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tarjetacredito")

public class TarjetaCred {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTarjeta;

	@NotEmpty(message = "Debe ingresar su numero de tarjeta completo")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "NumTarjeta", nullable = false, length = 16)
	private String NumTarjeta;
	
	@ManyToOne
	@JoinColumn(name = "CEntidad", nullable = false)
	private EntidadBancaria entidad;

	@ManyToOne
	@JoinColumn(name = "CTTarjeta", nullable = false)
	private TipotarjetaCred ttarjeta;

	@ManyToOne
	@JoinColumn(name = "CDNI", nullable = false)
	private Usuario usuario;
	
	public int getCTarjeta() {
		return CTarjeta;
	}

	public void setCTarjeta(int cTarjeta) {
		CTarjeta = cTarjeta;
	}

	public String getNumTarjeta() {
		return NumTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		NumTarjeta = numTarjeta;
	}

	public EntidadBancaria getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadBancaria entidad) {
		this.entidad = entidad;
	}

	public TipotarjetaCred getTtarjeta() {
		return ttarjeta;
	}

	public void setTtarjeta(TipotarjetaCred ttarjeta) {
		this.ttarjeta = ttarjeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
