package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.TarjetaMetropolitano;
import pe.metrogo.spring.repository.ITarjetaMetropolitanoRepository;
import pe.metrogo.spring.service.ITarjetaMetropolitanoService;

@Service
public class TarjetaMetropolitanoServiceImpl implements ITarjetaMetropolitanoService {

	@Autowired
	private ITarjetaMetropolitanoRepository dTMetro;
	
	@Override
	@Transactional
	public boolean insertar(TarjetaMetropolitano tmetro) {
		// TODO Auto-generated method stub
		TarjetaMetropolitano objTMetro = dTMetro.save(tmetro);
		if (objTMetro == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(TarjetaMetropolitano tmetro) {
		boolean flag = false;
		try {
			dTMetro.save(tmetro);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CTarjetaMetro) {
		// TODO Auto-generated method stub
		dTMetro.deleteById(CTarjetaMetro);
	}

	@Override
	@Transactional
	public Optional<TarjetaMetropolitano> listarId(int CTarjetaMetro) {
		// TODO Auto-generated method stub
		return dTMetro.findById(CTarjetaMetro);
	}

	@Override
	@Transactional
	public List<TarjetaMetropolitano> listar() {
		// TODO Auto-generated method stub
		return dTMetro.findAll();
	}

	@Override
	@Transactional
	public List<TarjetaMetropolitano> buscarTarjetaMetropolitano(String NumTMetro) {
		// TODO Auto-generated method stub
		return dTMetro.buscarTarjetaMetropolitano(NumTMetro);
	}
}
