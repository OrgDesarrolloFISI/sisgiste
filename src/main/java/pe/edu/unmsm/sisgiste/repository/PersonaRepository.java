package pe.edu.unmsm.sisgiste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.unmsm.sisgiste.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>{

	public abstract Persona findByPersonaCodigoSistema(String personaCodigoSistema);
	
}
