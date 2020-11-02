package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TarjetaMetropolitano;

@Repository
public interface ITarjetaMetropolitanoRepository extends JpaRepository<TarjetaMetropolitano, Integer> {

	@Query("From TarjetaMetropolitano t where t.NumTMetro like %:NumTMetro%")
	List<TarjetaMetropolitano> buscarTarjetaMetropolitano(@Param("NumTMetro") String NumTMetro);
}
