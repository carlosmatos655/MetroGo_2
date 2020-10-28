package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.Usuario;

public interface IUsuarioService {
	
	public boolean insertar(Usuario usuario);
	public boolean modificar(Usuario usuario);
	public void eliminar(int CDNI);
	public Optional<Usuario> listarId(int CDNI);
	List<Usuario> listar();
	List<Usuario> buscarUsuario(String NNombreyApellido);
	List<Usuario> buscarNacionalidad(String NNacionalidad);
}
