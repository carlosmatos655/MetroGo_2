package pe.metrogo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TarjetaMetropolitano;

@Repository
public interface ITarjetaMetropolitanoRepository extends JpaRepository<TarjetaMetropolitano,Integer>{
	
	//@Query("From Nacionalidad n where n.NNacionalidad like %:NNacionalidad%")
	//List<TarjetaMetropolitano> buscarNacionalidad(@Param("NNacionalidad")String NNacionalidad);
}
