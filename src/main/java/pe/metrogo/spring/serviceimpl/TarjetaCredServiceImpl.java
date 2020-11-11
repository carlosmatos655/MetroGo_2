package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.TarjetaCred;
import pe.metrogo.spring.repository.ITarjetaCredRepository;
import pe.metrogo.spring.service.ITarjetaCredService;

@Service
public class TarjetaCredServiceImpl implements ITarjetaCredService{

	@Autowired
	private ITarjetaCredRepository dTar; 
	
	@Override
	@Transactional
	public boolean insertar(TarjetaCred tar) {
		TarjetaCred objTar = dTar.save(tar);
		if(objTar == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(TarjetaCred tar) {
		boolean flag= false;
		try {
			dTar.save(tar);
			flag = true;
			
		} catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CTarjeta) {
		dTar.deleteById(CTarjeta);		
	}

	@Override
	@Transactional
	public Optional<TarjetaCred> listarId(int CTarjeta) {
		return dTar.findById(CTarjeta);
	}

	@Override
	@Transactional
	public List<TarjetaCred> listar() {
		return dTar.findAll();
	}

	@Override
	@Transactional
	public List<TarjetaCred> findByNumTarjeta(String NumTarjeta) {		
		return dTar.findByNumTarjeta(NumTarjeta);
	}
}