package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.TarjetaCred;

@Repository
public interface ITarjetaCredRepository extends JpaRepository<TarjetaCred, Integer> {

	List<TarjetaCred> findByNumTarjeta(String NumTarjeta);
}
