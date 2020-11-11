package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Promocion;

@Repository
public interface IPromocionRepository extends JpaRepository<Promocion,Integer>{
	
	List<Promocion> findByNPromocion(String NPromocion);
}
