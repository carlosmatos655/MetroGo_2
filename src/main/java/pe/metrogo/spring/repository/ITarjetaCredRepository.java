package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TarjetaCred;

@Repository
public interface ITarjetaCredRepository extends JpaRepository<TarjetaCred, Integer> {

	@Query("From TarjetaCred t where t.usuario.NNombreyApellido like %:NNombreyApellido%")
	List<TarjetaCred> buscarUsuario(@Param("NNombreyApellido") String NNombreyApellido);

	@Query("From TarjetaCred t where t.entidad.NEntidad like %:NEntidad%")
	List<TarjetaCred> buscarEntidadBancaria(@Param("NEntidad")String NEntidad);
	
	@Query("From TarjetaCred t where t.ttarjeta.NTTarjeta like %:NTTarjeta%")
	List<TarjetaCred> buscarTipoTarjeta(@Param("NTTarjeta")String NTTarjeta);
}
