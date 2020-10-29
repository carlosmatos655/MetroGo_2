package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Recarga;

@Repository
public interface IRecargaRepository extends JpaRepository<Recarga, Integer> {

	@Query("From Recarga t where t.tarjetametropolitano.CTarjetaMetro like %:CTarjetaMetro%")
	List<Recarga> buscarTarjetaMetropolitano(@Param("CTarjetaMetro") String CTarjetaMetro);

	@Query("From Promocion t where t.promocion.NPromocion like %:NPromocion%")
	List<Recarga> buscarPromocion(@Param("NPromocion")String NPromocion);
}
