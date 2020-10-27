package pe.metrogo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.metrogo.spring.entity.Usuario;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>  {
	@Query("select count(u.NNombreyApellido) from Usuario u where u.NNombreyApellido =:NNombreyApellido")
	public int buscarNombreUsuario(@Param("NNombreyApellido") String nombreUsuario);
}
