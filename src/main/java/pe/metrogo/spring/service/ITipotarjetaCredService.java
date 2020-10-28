package pe.metrogo.spring.service;

import java.util.List;
import java.util.Optional;

import pe.metrogo.spring.entity.TipotarjetaCred;

public interface ITipotarjetaCredService {
	
	public boolean insertar(TipotarjetaCred ttarjeta);
	public boolean modificar(TipotarjetaCred ttarjeta);
	public void eliminar(int CTTarjeta);
	public Optional<TipotarjetaCred> listarId(int CTTarjeta);
	List<TipotarjetaCred> listar();
	List<TipotarjetaCred> buscarTipotarjetaCred(String NTTarjeta);
}
