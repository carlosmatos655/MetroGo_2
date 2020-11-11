package pe.metrogo.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "promocion")

public class Promocion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CPromocion;

	@NotEmpty(message = "Debe ingresar el nombre de la promoción")
	@Column(name = "NPromocion", nullable = false, length = 30)
	private String NPromocion;

	@Column(name = "TDescripcion", nullable = false, length = 70)
	private String TDescripcion;

	@Max(value = 100, message = "No se permite ingresar valores superiores a S/ .100")
	@Min(value = 1,  message = "No se permite ingresar valores inferiores a S/ .1")
	private double MDescuento;

	@NotNull
	@Past(message = "Ingresar una fecha de inicio de la promoción")
	@Temporal(TemporalType.DATE)
	@Column(name = "DInicio")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DInicio;

	@NotNull
	@Past(message = "Ingresar una fecha de fin de la promoción")
	@Temporal(TemporalType.DATE)
	@Column(name = "DFin")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DFin;

	public int getCPromocion() {
		return CPromocion;
	}

	public void setCPromocion(int cPromocion) {
		CPromocion = cPromocion;
	}

	public String getNPromocion() {
		return NPromocion;
	}

	public void setNPromocion(String nPromocion) {
		NPromocion = nPromocion;
	}

	public String getTDescripcion() {
		return TDescripcion;
	}

	public void setTDescripcion(String tDescripcion) {
		TDescripcion = tDescripcion;
	}
	
	public double getMDescuento() {
		return MDescuento;
	}

	public void setMDescuento(double mDescuento) {
		MDescuento = mDescuento;
	}

	public Date getDInicio() {
		return DInicio;
	}

	public void setDInicio(Date dInicio) {
		DInicio = dInicio;
	}

	public Date getDFin() {
		return DFin;
	}

	public void setDFin(Date dFin) {
		DFin = dFin;
	}

}
