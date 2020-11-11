package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	List<Cliente> findByNNombreyApellido(String NNombreyApellido);

	List<Cliente> findByNumDNI(String NumDNI);
}
