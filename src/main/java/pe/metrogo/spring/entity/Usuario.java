package pe.metrogo.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty(message = "Debe ingresar su nombre completo")
	@NotBlank(message = "No puede estar en blanco")
	private int CDNI;

	@NotEmpty(message = "Debe ingresar su nombre completo")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "NNombreyApellido", nullable = false, length = 30)
	private String NNombreyApellido;

	@NotEmpty(message = "Debe ingresar su correo completo")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "TCorreo", nullable = false, length = 30)
	private String TCorreo;

	@NotEmpty(message = "Debe ingresar su contraseña completa")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "CContraseña", nullable = false, length = 10)
	private String CContraseña;

	@NotNull
	@Past(message = "No puedes seleccionar un dia que no existe")
	@Temporal(TemporalType.DATE)
	@Column(name = "FNacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FNacimiento;

	@ManyToOne
	@JoinColumn(name = "CNacionalidad", nullable = false)
	private Nacionalidad nacionalidad;
	
	public int getCDNI() {
		return CDNI;
	}

	public void setCDNI(int cDNI) {
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

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
