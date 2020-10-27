package pe.metrogo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="entidadbancaria")
public class EntidadBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CEntidad;
		
	@NotEmpty(message="Debe ingresar el nombre de la entidad bancaria")
	@Column(name="NEntidad", nullable=false, length=30)
	private String NEntidad;

	public int getCEntidad() {
		return CEntidad;
	}

	public void setCEntidad(int cEntidad) {
		CEntidad = cEntidad;
	}

	public String getNEntidad() {
		return NEntidad;
	}

	public void setNEntidad(String nEntidad) {
		NEntidad = nEntidad;
	}

}
