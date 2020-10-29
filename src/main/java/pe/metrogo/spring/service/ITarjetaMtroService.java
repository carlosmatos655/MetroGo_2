package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.TarjetaMetropolitano;

public interface ITarjetaMtroService {
	
	public boolean insertar(TarjetaMetropolitano tarjeta);
	public boolean modificar(TarjetaMetropolitano tarjeta);
	public void eliminar(int CTarjetaMetro);
	public Optional<TarjetaMetropolitano> listarId(int CTarjetaMetro);
	List<TarjetaMetropolitano> listar();
	List<TarjetaMetropolitano> buscarUsuario(String NNombreyApellido);
	List<TarjetaMetropolitano> buscarTipotarjetaMtro(String NTTarjetaMetro);
}
