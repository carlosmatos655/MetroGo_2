package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.Promocion;
import pe.metrogo.spring.repository.IPromocionRepository;
import pe.metrogo.spring.service.IPromocionService;

@Service
public class PromocionServiceImpl implements IPromocionService {

	@Autowired
	private IPromocionRepository dPromocion;

	@Override
	@Transactional
	public boolean insertar(Promocion promocion) {
		// TODO Auto-generated method stub
		Promocion objPromocion = null;
		if (promocion.getDInicio().before(promocion.getDFin())) {
			objPromocion = dPromocion.save(promocion);
		}
		if (objPromocion == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Promocion promocion) {
		boolean flag = false;
		try {
			dPromocion.save(promocion);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CPromocion) {
		// TODO Auto-generated method stub
		dPromocion.deleteById(CPromocion);
	}

	@Override
	@Transactional
	public Optional<Promocion> listarId(int CPromocion) {
		// TODO Auto-generated method stub
		return dPromocion.findById(CPromocion);
	}

	@Override
	@Transactional
	public List<Promocion> listar() {
		// TODO Auto-generated method stub
		return dPromocion.findAll();
	}

	@Override
	@Transactional
	public List<Promocion> findByNPromocion(String NPromocion) {
		// TODO Auto-generated method stub
		return dPromocion.findByNPromocion(NPromocion);
	}

}
