package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.Usuario;
import pe.metrogo.spring.repository.IUsuarioRepository;
import pe.metrogo.spring.service.IUsuarioService;

public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository dUsu; 
	
	@Override
	@Transactional
	public boolean insertar(Usuario usu) {
		Usuario objUsu = dUsu.save(usu);
		if(objUsu == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Usuario usu) {
		boolean flag= false;
		try {
			dUsu.save(usu);
			flag = true;
		} catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CDNI) {
		dUsu.deleteById(CDNI);		
	}

	@Override
	@Transactional
	public Optional<Usuario> listarId(int CDNI) {
		return dUsu.findById(CDNI);
	}

	@Override
	@Transactional
	public List<Usuario> listar() {
		return dUsu.findAll();
	}

	@Override
	@Transactional
	public List<Usuario> buscarUsuario(String NNombreyApellido) {		
		return dUsu.buscarUsuario(NNombreyApellido);
	}

	@Override
	@Transactional
	public List<Usuario> buscarNacionalidad(String NNacionalidad) {
		return dUsu.buscarNacionalidad(NNacionalidad);
	}
}