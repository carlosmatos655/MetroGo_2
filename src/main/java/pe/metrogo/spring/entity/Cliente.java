package pe.metrogo.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "cliente")

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CCliente;

	@NotEmpty(message = "Debe ingresar su numero de dni completo")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "NumDNI", nullable = false, length = 8)
	private String numDNI;
	
	@NotEmpty(message = "Debe ingresar su nombre completo")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "NNombreyApellido", nullable = false, length = 30)
	private String NNombreyApellido;

	@NotEmpty(message = "Debe ingresar su correo completo")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "TCorreo", nullable = false, length = 30)
	private String TCorreo;

	@NotNull
	@Past(message = "No puedes seleccionar un dia que no existe")
	@Temporal(TemporalType.DATE)
	@Column(name = "FNacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FNacimiento;

	@ManyToOne
	@JoinColumn(name = "CNacionalidad", nullable = false)
	private Nacionalidad nacionalidad;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
	private Usuario usuario;
	
	public int getCCliente() {
		return CCliente;
	}

	public void setCCliente(int cCliente) {
		CCliente = cCliente;
	}

	public String getNumDNI() {
		return numDNI;
	}

	public void setNumDNI(String numDNI) {
		this.numDNI = numDNI;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
