package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.EntidadBancaria;

@Repository
public interface IEntidadBancariaRepository extends JpaRepository<EntidadBancaria,Integer>{
	
	@Query("From Entidad n where n.NEntidad like %:NEntidad%")
	List<EntidadBancaria> buscarEntidadBancaria(@Param("NEntidad")String NEntidad);
}
