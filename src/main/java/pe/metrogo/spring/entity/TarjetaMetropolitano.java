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
	
	

}
