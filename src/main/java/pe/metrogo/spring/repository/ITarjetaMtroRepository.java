package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TarjetaMetropolitano;

@Repository
public interface ITarjetaMtroRepository extends JpaRepository<TarjetaMetropolitano, Integer> {

	@Query("From TarjetaMetropolitano t where t.usuario.NNombreyApellido like %:NNombreyApellido%")
	List<TarjetaMetropolitano> buscarUsuario(@Param("NNombreyApellido") String NNombreyApellido);

	@Query("From TarjetaMetropolitano t where t.entidad.NTTarjetaMetro like %:NTTarjetaMetro%")
	List<TarjetaMetropolitano> buscarTipotarjetaMtro(@Param("NTTarjetaMetro")String NTTarjetaMetro);
}
