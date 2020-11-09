package pe.metrogo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("From Cliente u where u.NNombreyApellido like %:NNombreyApellido%")
	List<Cliente> buscarCliente(@Param("NNombreyApellido") String NNombreyApellido);

	@Query("From Cliente u where u.nacionalidad.NNacionalidad like %:NNacionalidad%")
	List<Cliente> buscarNacionalidad(@Param("NNacionalidad")String NNacionalidad);
	
	//List<Usuario> findByBirthDateUsuario(Date FNacimiento);
}
