package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Promocion;

@Repository
public interface IPromocionRepository extends JpaRepository<Promocion,Integer>{
	
	@Query("From Promocion p where p.NPromocion like %:NPromocion%")
	List<Promocion> buscarPromocion(@Param("NPromocion")String NPromocion);
}
