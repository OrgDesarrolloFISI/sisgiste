package pe.edu.unmsm.sisgiste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.unmsm.sisgiste.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

	@Query(value="SELECT u FROM Usuario as u WHERE u.persona.personaCodigo= :codigoPersona AND u.sistema.sistemaNombre= 'SISGISTE'")
	public abstract List<Usuario> findByCodigoPersona(@Param(value="codigoPersona")String codigoPersona);
}
