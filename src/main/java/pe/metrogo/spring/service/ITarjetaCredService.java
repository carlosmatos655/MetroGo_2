package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.TarjetaCred;

public interface ITarjetaCredService {
	
	public boolean insertar(TarjetaCred tarjeta);
	public boolean modificar(TarjetaCred tarjeta);
	public void eliminar(int CTarjeta);
	public Optional<TarjetaCred> listarId(int CTarjeta);
	List<TarjetaCred> listar();
	List<TarjetaCred> buscarEntidadBancaria(String NEntidad);
	List<TarjetaCred> buscarTipoTarjeta(String NTTarjeta);
	List<TarjetaCred> buscarCliente(String NNombreyApellido);
}
