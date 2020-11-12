package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TarjetaMetropolitano;

@Repository
public interface ITarjetaMetropolitanoRepository extends JpaRepository<TarjetaMetropolitano, Integer> {

	List<TarjetaMetropolitano> findByNumTMetro(String numTMetro);
}
