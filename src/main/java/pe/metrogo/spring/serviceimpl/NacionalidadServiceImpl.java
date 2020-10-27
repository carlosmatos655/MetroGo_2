package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.Nacionalidad;
import pe.metrogo.spring.repository.INacionalidadRepository;
import pe.metrogo.spring.service.INacionalidadService;

@Service
public class NacionalidadServiceImpl implements INacionalidadService{
	
	@Autowired
	private INacionalidadRepository dNacionalidad;

	@Override
	@Transactional
	public boolean insertar(Nacionalidad nacionalidad) {
		// TODO Auto-generated method stub
		Nacionalidad objNacionalidad = dNacionalidad.save(nacionalidad);
		if(objNacionalidad == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Nacionalidad nacionalidad) {
		boolean flag = false;
		try {
			dNacionalidad.save(nacionalidad);
			flag = true;
		}catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CNacionalidad) {
		// TODO Auto-generated method stub
		dNacionalidad.deleteById(CNacionalidad);
	}

	@Override
	@Transactional
	public Optional<Nacionalidad> listarId(int CNacionalidad) {
		// TODO Auto-generated method stub
		return dNacionalidad.findById(CNacionalidad);
	}

	@Override
	@Transactional
	public List<Nacionalidad> listar() {
		// TODO Auto-generated method stub
		return dNacionalidad.findAll();
	}

	@Override
	@Transactional
	public List<Nacionalidad> buscarNacionalidad(String NNacionalidad) {
		// TODO Auto-generated method stub
		return dNacionalidad.buscarNacionalidad(NNacionalidad);
	}
	
}
