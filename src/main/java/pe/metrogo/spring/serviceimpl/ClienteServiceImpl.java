package pe.metrogo.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.metrogo.spring.entity.Cliente;
import pe.metrogo.spring.repository.IClienteRepository;
import pe.metrogo.spring.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository dCli; 
	
	@Override
	@Transactional
	public boolean insertar(Cliente cli) {
		Cliente objCliente = dCli.save(cli);
		if(objCliente == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Cliente cli) {
		boolean flag= false;
		try {
			dCli.save(cli);
			flag = true;
		} catch(Exception ex){
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int CCliente) {
		dCli.deleteById(CCliente);		
	}

	@Override
	@Transactional
	public Optional<Cliente> listarId(int CCliente) {
		return dCli.findById(CCliente);
	}

	@Override
	@Transactional
	public List<Cliente> listar() {
		return dCli.findAll();
	}

	@Override
	@Transactional
	public List<Cliente> buscarCliente(String NNombreyApellido) {		
		return dCli.buscarCliente(NNombreyApellido);
	}

	@Override
	@Transactional
	public List<Cliente> buscarNacionalidad(String NNacionalidad) {
		return dCli.buscarNacionalidad(NNacionalidad);
	}
}