package pe.metrogo.spring.entity;

import java.util.Date;
import java.util.Timer;

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
@Table(name="recarga")

public class Recarga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CRecarga;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que no existe")
	@Temporal(TemporalType.DATE)
	@Column(name="DFecha")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date DFecha;
	
	@NotNull
	@Past(message="No puedes seleccionar una hora que no existe")
	@Temporal(TemporalType.TIME)
	@Column(name="DHora")
	private Timer DHora;
	
	@NotNull
	@Past(message="No puede dejar este espacio en blanco ingresar monto a recargar")
	@Column(name="MMonto")
	private double Monto;
	
	@ManyToOne
	@JoinColumn(name = "CTarjetaMetro", nullable = false)
	private TarjetaMetropolitano tarjetametropolitano;
	
	@ManyToOne
	@JoinColumn(name = "CPromocion", nullable = false)
	private Promocion promocion;

	public int getCRecarga() {
		return CRecarga;
	}

	public void setCRecarga(int cRecarga) {
		CRecarga = cRecarga;
	}

	public Date getDFecha() {
		return DFecha;
	}

	public void setDFecha(Date dFecha) {
		DFecha = dFecha;
	}

	public Timer getDHora() {
		return DHora;
	}

	public void setDHora(Timer dHora) {
		DHora = dHora;
	}

	public double getMonto() {
		return Monto;
	}

	public void setMonto(double monto) {
		Monto = monto;
	}
	
	public TarjetaMetropolitano getTarjetaMetropolitano() {
		return tarjetametropolitano;
	}
	
	public void setTarjetaMetropolitano(TarjetaMetropolitano tarjetametropolitano) {
		this.tarjetametropolitano = tarjetametropolitano;
	}
	
	public Promocion getPromocion() {
		return promocion;
	}
	
	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}
}