package pe.metrogo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipotarjetametro")
public class TipotarjetaMtro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CTTarjetaMetro;
	
	
	@Column(name="NTTarjeta", nullable=false, length=30)
	private String NTTarjetaMetro;


	public int getCTTarjetaMetro() {
		return CTTarjetaMetro;
	}


	public void setCTTarjetaMetro(int cTTarjetaMetro) {
		CTTarjetaMetro = cTTarjetaMetro;
	}


	public String getNTTarjetaMetro() {
		return NTTarjetaMetro;
	}


	public void setNTTarjetaMetro(String nTTarjetaMetro) {
		NTTarjetaMetro = nTTarjetaMetro;
	}
	
	

}
