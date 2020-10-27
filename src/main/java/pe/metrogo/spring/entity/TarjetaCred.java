package pe.metrogo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tarjetacredito")

public class TarjetaCred {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTarjeta;
		
	@NotEmpty(message="Debe ingresar un titular")
	@Column(name="NTitular", nullable=false, length=30)
	private String NTitular;

	public int getCTarjeta() {
		return CTarjeta;
	}

	public void setCTarjeta(int cTarjeta) {
		CTarjeta = cTarjeta;
	}

	public String getNTitular() {
		return NTitular;
	}

	public void setNTitular(String nTitular) {
		NTitular = nTitular;
	}
	
	

}
