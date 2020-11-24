package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.Usuario;
import pe.metrogo.spring.repository.IUsuarioRepository;
import pe.metrogo.spring.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository dUsuario;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public boolean insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		//Aqui poner roles
		Usuario objUsuario = dUsuario.save(usuario);
		if(objUsuario == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean modificar(Usuario usuario) {
		boolean flag= false;
		try {
			dUsuario.save(usuario);
			flag = true;
		} catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dUsuario.deleteById(id);	
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		// TODO Auto-generated method stub
		return dUsuario.findById(id);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return dUsuario.findAll();
	}
}
