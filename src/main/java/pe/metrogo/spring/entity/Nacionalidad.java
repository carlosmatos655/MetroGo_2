package pe.metrogo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="nacionalidad")
public class Nacionalidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CNacionalidad;
		
	@NotEmpty(message="Debe ingresar una nacionalidad")
	@Column(name="NNacionalidad", nullable=false, length=50)
	private String NNacionalidad;

	public int getCNacionalidad() {
		return CNacionalidad;
	}

	public void setCNacionalidad(int cNacionalidad) {
		CNacionalidad = cNacionalidad;
	}

	public String getNNacionalidad() {
		return NNacionalidad;
	}

	public void setNNacionalidad(String nNacionalidad) {
		NNacionalidad = nNacionalidad;
	}
	
}
