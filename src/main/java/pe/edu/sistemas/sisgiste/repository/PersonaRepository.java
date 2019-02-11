package pe.edu.sistemas.sisgiste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisgiste.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>{

	public abstract Persona findByPersonaCodigoSistema(String personaCodigoSistema);
	
}
