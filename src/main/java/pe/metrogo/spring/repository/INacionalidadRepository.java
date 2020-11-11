package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Nacionalidad;

@Repository
public interface INacionalidadRepository extends JpaRepository<Nacionalidad,Integer>{
	
	List<Nacionalidad> findByNNacionalidad(String NNacionalidad);
}
