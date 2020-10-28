package pe.metrogo.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tarjetacredito")

public class TarjetaCred {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTarjeta;

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
