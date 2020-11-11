package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TipotarjetaCred;

@Repository
public interface ITipoTarjetaCredRepository extends JpaRepository<TipotarjetaCred,Integer>{
	
	List<TipotarjetaCred> findByNTTarjeta(String NTTarjeta);
}
