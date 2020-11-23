
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	
	@Max(value = 500, message = "No se permite ingresar valores superiores a S/ .500")
	@Min(value = 1,  message = "No se permite ingresar valores inferiores a S/ .1")
	private double MMonto;

	@ManyToOne
	@JoinColumn(name = "CPromocion")
	private Promocion promocion;

	@ManyToOne
	@JoinColumn(name = "CTarjetaMetro", nullable = false)
	private TarjetaMetropolitano tmetro;
	
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

	public double getMMonto() {
		return MMonto;
	}

	public void setMMonto(double mMonto) {
		MMonto = mMonto;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	public TarjetaMetropolitano getTmetro() {
		return tmetro;
	}

	public void setTmetro(TarjetaMetropolitano tmetro) {
		this.tmetro = tmetro;
	}
	
}