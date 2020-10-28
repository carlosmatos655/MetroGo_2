package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.EntidadBancaria;
import pe.metrogo.spring.repository.IEntidadBancariaRepository;
import pe.metrogo.spring.service.IEntidadBancariaService;

@Service
public class EntidadBancariaServiceImpl implements IEntidadBancariaService{
	
	@Autowired
	private IEntidadBancariaRepository dEntidad;

	@Override
	@Transactional
	public boolean insertar(EntidadBancaria entidad) {
		// TODO Auto-generated method stub
		EntidadBancaria objEntidad = dEntidad.save(entidad);
		if(objEntidad == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(EntidadBancaria entidad) {
		boolean flag = false;
		try {
			dEntidad.save(entidad);
			flag = true;
		}catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CEntidad) {
		// TODO Auto-generated method stub
		dEntidad.deleteById(CEntidad);
	}

	@Override
	@Transactional
	public Optional<EntidadBancaria> listarId(int CEntidad) {
		// TODO Auto-generated method stub
		return dEntidad.findById(CEntidad);
	}

	@Override
	@Transactional
	public List<EntidadBancaria> listar() {
		// TODO Auto-generated method stub
		return dEntidad.findAll();
	}

	@Override
	@Transactional
	public List<EntidadBancaria> buscarEntidadBancaria(String NEntidad) {
		// TODO Auto-generated method stub
		return dEntidad.buscarEntidadBancaria(NEntidad);
	}
	
}
