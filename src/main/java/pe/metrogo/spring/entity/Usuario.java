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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuario")

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long CDNI;
	
	@NotEmpty(message="Debe ingresar su nombre completo")
	@Column(name="NNombreyApellido", nullable=false, length=30)
	private String NNombreyApellido;
	
	@Column(name="TCorreo", nullable=false, length=30)
	private String TCorreo;
	
	@Column(name="CContraseña", nullable=false, length=10)
	private String CContraseña;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que no existe")
	@Temporal(TemporalType.DATE)
	@Column(name="FNacimiento")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date FNacimiento;

	public long getCDNI() {
		return CDNI;
	}

	public void setCDNI(long cDNI) {
		CDNI = cDNI;
	}

	public String getNNombreyApellido() {
		return NNombreyApellido;
	}

	public void setNNombreyApellido(String nNombreyApellido) {
		NNombreyApellido = nNombreyApellido;
	}

	public String getTCorreo() {
		return TCorreo;
	}

	public void setTCorreo(String tCorreo) {
		TCorreo = tCorreo;
	}

	public String getCContraseña() {
		return CContraseña;
	}

	public void setCContraseña(String cContraseña) {
		CContraseña = cContraseña;
	}

	public Date getFNacimiento() {
		return FNacimiento;
	}

	public void setFNacimiento(Date fNacimiento) {
		FNacimiento = fNacimiento;
	}
	
}
