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
	private IRecargaRepository dTrec; 
	
	@Override
	@Transactional
	public boolean insertar(Recarga tre) {
		Recarga objTrec = dTrec.save(tre);
		if(objTrec == null)
			return false;
		else
			return true;
	}

	@Transactional
	public boolean modificar(Recarga tre) {
		boolean flag= false;
		try {
			dTrec.save(tre);
			flag = true;
			
		} catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CRecarga) {
		dTrec.deleteById(CRecarga);		
	}

	@Override
	@Transactional
	public Optional<Recarga> listarId(int CRecarga) {
		return dTrec.findById(CRecarga);
	}

	@Override
	@Transactional
	public List<Recarga> listar() {
		return dTrec.findAll();
	}

	@Transactional
	public List<Recarga> buscarTarjetaMetropolitano(String CTarjetaMetro) {		
		return dTrec.buscarTarjetaMetropolitano(CTarjetaMetro);
	}

	@Transactional
	public List<Recarga> buscarPromocion(String NPromocion) {		
		return dTrec.buscarPromocion(NPromocion);
	}

	@Override
	public List<Recarga> buscarUsuario(String NNombreyApellido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recarga> buscarTipotarjetaMtro(String NTTarjetaMetro) {
		// TODO Auto-generated method stub
		return null;
	}

}