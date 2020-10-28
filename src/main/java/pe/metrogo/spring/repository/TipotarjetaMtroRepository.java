package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TipotarjetaMtro;

@Repository
public interface TipotarjetaMtroRepository extends JpaRepository<TipotarjetaMtro,Integer>{
	
	@Query("From TipotarjetaMtro t where t.NTTarjetaMetro like %:NTTarjetaMetro%")
	List<TipotarjetaMtro> buscarTipotarjetaMtro(@Param("NTTarjetaMetro")String NTTarjetaMetro);
}
