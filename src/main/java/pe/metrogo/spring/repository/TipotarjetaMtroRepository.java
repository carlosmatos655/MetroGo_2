package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TipotarjetaMtro;

@Repository
public interface TipotarjetaMtroRepository extends JpaRepository<TipotarjetaMtro,Integer>{
	
	List<TipotarjetaMtro> findByNTTarjetaMetro(String NTTarjetaMetro);
}
