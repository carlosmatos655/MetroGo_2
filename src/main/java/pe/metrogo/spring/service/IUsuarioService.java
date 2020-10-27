package pe.metrogo.spring.service;

import java.util.List;

import pe.metrogo.spring.entity.Usuario;

public interface IUsuarioService {
	
	public Integer insert(Usuario usuario);
	public void delete (long idUsuario);
	List<Usuario> list();

}
