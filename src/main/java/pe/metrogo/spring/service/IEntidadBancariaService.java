package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.EntidadBancaria;

public interface IEntidadBancariaService {
	
	public boolean insertar(EntidadBancaria entidad);
	public boolean modificar(EntidadBancaria entidad);
	public void eliminar(int CEntidad);
	public Optional<EntidadBancaria> listarId(int CEntidad);
	List<EntidadBancaria> listar();
	List<EntidadBancaria> buscarEntidadBancaria(String NEntidad);
}
