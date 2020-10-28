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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tarjetametropolitano")
public class TarjetaMetropolitano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTarjetaMetro;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que no existe")
	@Temporal(TemporalType.DATE)
	@Column(name="DVencimiento")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date DVencimiento;
	
	@ManyToOne
	@JoinColumn(name = "CDNI", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "CTTarjetaMetro", nullable = false)
	private TipotarjetaMtro tipotarjetametro;
	
	public int getCTarjetaMetro() {
		return CTarjetaMetro;
	}

	public void setCTarjetaMetro(int cTarjetaMetro) {
		CTarjetaMetro = cTarjetaMetro;
	}

	public Date getDVencimiento() {
		return DVencimiento;
	}

	public void setDVencimiento(Date dVencimiento) {
		DVencimiento = dVencimiento;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipotarjetaMtro getTipotarjetaMtro() {
		return tipotarjetametro;
	}

	public void setTipotarjetaMtro(TipotarjetaMtro tipotarjetametro) {
		this.tipotarjetametro = tipotarjetametro;
	}
}
