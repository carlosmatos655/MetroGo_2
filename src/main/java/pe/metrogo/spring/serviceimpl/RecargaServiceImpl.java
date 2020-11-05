package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.Recarga;
import pe.metrogo.spring.repository.IRecargaRepository;
import pe.metrogo.spring.service.IRecargaService;

@Service
public class RecargaServiceImpl implements IRecargaService{
	
	@Autowired
	private IRecargaRepository dRecarga;

	@Override
	@Transactional
	public boolean insertar(Recarga recarga) {
		// TODO Auto-generated method stub
		Recarga objRecarga = dRecarga.save(recarga);
		if(objRecarga == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Recarga recarga) {
		boolean flag = false;
		try {
			dRecarga.save(recarga);
			flag = true;
		}catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CRecarga) {
		// TODO Auto-generated method stub
		dRecarga.deleteById(CRecarga);
	}

	@Override
	@Transactional
	public Optional<Recarga> listarId(int CRecarga) {
		// TODO Auto-generated method stub
		return dRecarga.findById(CRecarga);
	}

	@Override
	@Transactional
	public List<Recarga> listar() {
		// TODO Auto-generated method stub
		return dRecarga.findAll();
	}

}
