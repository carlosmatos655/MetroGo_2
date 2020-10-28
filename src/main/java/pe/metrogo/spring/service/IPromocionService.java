package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.Promocion;

public interface IPromocionService {
	
	public boolean insertar(Promocion promocion);
	public boolean modificar(Promocion promocion);
	public void eliminar(int CPromocion);
	public Optional<Promocion> listarId(int CPromocion);
	List<Promocion> listar();
	List<Promocion> buscarPromocion(String NPromocion);
}
