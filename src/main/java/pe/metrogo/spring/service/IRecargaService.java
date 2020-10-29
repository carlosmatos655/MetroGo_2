package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.Recarga;

public interface IRecargaService {
	
	public boolean insertar(Recarga recarga);
	public boolean modificar(Recarga recarga);
	public void eliminar(int CRecarga);
	public Optional<Recarga> listarId(int CRecarga);
	List<Recarga> listar();
	List<Recarga> buscarUsuario(String NNombreyApellido);
	List<Recarga> buscarTipotarjetaMtro(String NTTarjetaMetro);
	List<Recarga> buscarTarjetaMetropolitano(String CTarjetaMetro);
}
