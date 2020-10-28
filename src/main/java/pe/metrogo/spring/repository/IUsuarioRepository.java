package pe.metrogo.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("From Usuario u where u.NNombreyApellido like %:NNombreyApellido%")
	List<Usuario> buscarUsuario(@Param("NUsuario") String NUsuario);

	@Query("From Usuario u where u.nacionalidad.NNacionalidad like %:NNacionalidad%")
	List<Usuario> buscarNacionalidad(@Param("NNacionalidad")String NNacionalidad);
	
	List<Usuario> findByBirthDateUsuario(Date FNacimiento);
}
