package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.Cliente;

public interface IClienteService {
	
	public boolean insertar(Cliente cliente);
	public boolean modificar(Cliente cliente);
	public void eliminar(int CCliente);
	public Optional<Cliente> listarId(int CCliente);
	List<Cliente> listar();
	List<Cliente> findByNNombreyApellido(String NNombreyApellido);
	//List<Cliente> findByNumDNI(String NumDNI);
}
