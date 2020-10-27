package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Nacionalidad;

@Repository
public interface INacionalidadRepository extends JpaRepository<Nacionalidad,Integer>{
	
	@Query("From Nacionalidad n where n.NNacionalidad like %:NNacionalidad%")
	List<Nacionalidad> buscarNacionalidad(@Param("NNacionalidad")String NNacionalidad);
}
