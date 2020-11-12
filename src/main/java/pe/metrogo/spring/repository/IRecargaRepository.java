package pe.metrogo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Recarga;

@Repository
public interface IRecargaRepository extends JpaRepository<Recarga,Integer>{
	
	//@Query("From Recarga n where n.NNacionalidad like %:NNacionalidad%")
	//List<Recarga> buscarNacionalidad(@Param("NNacionalidad")String NNacionalidad);
}
