package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.TarjetaMetropolitano;

public interface ITarjetaMetropolitanoService {

	public boolean insertar(TarjetaMetropolitano tmetro);

	public boolean modificar(TarjetaMetropolitano tmetro);

	public void eliminar(int CTarjetaMetro);

	public Optional<TarjetaMetropolitano> listarId(int CTarjetaMetro);

	List<TarjetaMetropolitano> listar();

	List<TarjetaMetropolitano> findByNumTMetro(String NumTMetro);
}
