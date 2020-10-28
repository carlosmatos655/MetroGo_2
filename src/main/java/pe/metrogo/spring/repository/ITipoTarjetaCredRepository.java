package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TipotarjetaCred;

@Repository
public interface ITipoTarjetaCredRepository extends JpaRepository<TipotarjetaCred,Integer>{
	
	@Query("From TipotarjetaCred t where t.NTTarjeta like %:NTTarjeta%")
	List<TipotarjetaCred> buscarTipotarjetaCred(@Param("NTTarjeta")String NTTarjeta);
}
