package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.TarjetaMetropolitano;
import pe.metrogo.spring.repository.ITarjetaMtroRepository;
import pe.metrogo.spring.service.ITarjetaMtroService;

@Service
public class TarjetaMtroServiceImpl implements ITarjetaMtroService{

	@Autowired
	private ITarjetaMtroRepository dTam; 
	
	@Override
	@Transactional
	public boolean insertar(TarjetaMetropolitano tam) {
		TarjetaMetropolitano objTam = dTam.save(tam);
		if(objTam == null)
			return false;
		else
			return true;
	}

	@Transactional
	public boolean modificar(TarjetaMetropolitano tam) {
		boolean flag= false;
		try {
			dTam.save(tam);
			flag = true;
			
		} catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CTarjetaMetro) {
		dTam.deleteById(CTarjetaMetro);		
	}

	@Override
	@Transactional
	public Optional<TarjetaMetropolitano> listarId(int CTarjetaMetro) {
		return dTam.findById(CTarjetaMetro);
	}

	@Override
	@Transactional
	public List<TarjetaMetropolitano> listar() {
		return dTam.findAll();
	}

	@Override
	@Transactional
	public List<TarjetaMetropolitano> buscarUsuario(String NNombreyApellido) {		
		return dTam.buscarUsuario(NNombreyApellido);
	}

	@Transactional
	public List<TarjetaMetropolitano> buscarTipotarjetaMtro(String NTTarjetaMetro) {		
		return dTam.buscarTipotarjetaMtro(NTTarjetaMetro);
	}

}