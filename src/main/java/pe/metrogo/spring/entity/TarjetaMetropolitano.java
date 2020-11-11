package pe.metrogo.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tarjetametropolitano")
public class TarjetaMetropolitano {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTarjetaMetro;

	@NotEmpty(message = "Debe ingresar su numero de tarjeta completo")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "NumTMetro", nullable = false, length = 10)
	private String numTMetro;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "DVencimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DVencimiento;

	@ManyToOne
	@JoinColumn(name = "CCliente", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "CTTarjetaMetro", nullable = false)
	private TipotarjetaMtro ttarjetametro;

	public int getCTarjetaMetro() {
		return CTarjetaMetro;
	}

	public void setCTarjetaMetro(int cTarjetaMetro) {
		CTarjetaMetro = cTarjetaMetro;
	}
	
	public String getNumTMetro() {
		return numTMetro;
	}

	public void setNumTMetro(String numTMetro) {
		this.numTMetro = numTMetro;
	}

	public Date getDVencimiento() {
		return DVencimiento;
	}

	public void setDVencimiento(Date dVencimiento) {
		DVencimiento = dVencimiento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipotarjetaMtro getTtarjetametro() {
		return ttarjetametro;
	}

	public void setTtarjetametro(TipotarjetaMtro ttarjetametro) {
		this.ttarjetametro = ttarjetametro;
	}

}
