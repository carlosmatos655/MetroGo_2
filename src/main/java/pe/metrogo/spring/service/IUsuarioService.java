package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.Usuario;

public interface IUsuarioService {
	
	public boolean insertar(Usuario usuario);
	public boolean modificar(Usuario usuario);
	public void eliminar(int id);
	public Optional<Usuario> listarId(int id);
	List<Usuario> listar();
}
