package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.TipotarjetaMtro;
import pe.metrogo.spring.repository.TipotarjetaMtroRepository;
import pe.metrogo.spring.service.ITipotarjetaMtroService;

@Service
public class TipotarjetaMtroServiceImpl implements ITipotarjetaMtroService{
	
	@Autowired
	private TipotarjetaMtroRepository dTTarjetaMetro;

	@Override
	@Transactional
	public boolean insertar(TipotarjetaMtro ttarjetametro) {
		// TODO Auto-generated method stub
		TipotarjetaMtro objTTarjetametro = dTTarjetaMetro.save(ttarjetametro);
		if(objTTarjetametro == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(TipotarjetaMtro ttarjetametro) {
		boolean flag = false;
		try {
			dTTarjetaMetro.save(ttarjetametro);
			flag = true;
		}catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CTTarjetaMetro) {
		// TODO Auto-generated method stub
		dTTarjetaMetro.deleteById(CTTarjetaMetro);
	}

	@Override
	@Transactional
	public Optional<TipotarjetaMtro> listarId(int CTTarjetaMetro) {
		// TODO Auto-generated method stub
		return dTTarjetaMetro.findById(CTTarjetaMetro);
	}

	@Override
	@Transactional
	public List<TipotarjetaMtro> listar() {
		// TODO Auto-generated method stub
		return dTTarjetaMetro.findAll();
	}

	@Override
	@Transactional
	public List<TipotarjetaMtro> findByNTTarjetaMetro(String NNTarjetaMetro) {
		// TODO Auto-generated method stub
		return dTTarjetaMetro.findByNTTarjetaMetro(NNTarjetaMetro);
	}
	
}
