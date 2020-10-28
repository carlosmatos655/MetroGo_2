package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.TipotarjetaMtro;

public interface ITipotarjetaMtroService {
	
	public boolean insertar(TipotarjetaMtro ttarjetametro);
	public boolean modificar(TipotarjetaMtro ttarjetametro);
	public void eliminar(int CTTarjetaMetro);
	public Optional<TipotarjetaMtro> listarId(int CTTarjetaMetro);
	List<TipotarjetaMtro> listar();
	List<TipotarjetaMtro> buscarTipotarjetaMtro(String NTTarjetaMetro);
}
