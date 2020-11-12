package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.Nacionalidad;

public interface INacionalidadService {
	
	public boolean insertar(Nacionalidad nacionalidad);
	public boolean modificar(Nacionalidad nacionalidad);
	public void eliminar(int CNacionalidad);
	public Optional<Nacionalidad> listarId(int CNacionalidad);
	List<Nacionalidad> listar();
	List<Nacionalidad> findByNNacionalidad(String NNacionalidad);
}
