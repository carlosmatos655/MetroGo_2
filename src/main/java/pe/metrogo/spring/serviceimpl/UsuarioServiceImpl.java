package pe.metrogo.spring.serviceimpl;

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
}
