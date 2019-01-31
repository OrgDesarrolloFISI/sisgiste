package pe.edu.unmsm.sisgiste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.unmsm.sisgiste.entity.Incidencia;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia,Integer>{

	public Incidencia findByIdIncidencia(Integer idIncidencia);
	
	public Incidencia findFirstByOrderByIdIncidenciaDesc();
	
	@Query("SELECT I from Incidencia as I WHERE I.estado= '1'")
	public List<Incidencia> findIncidenciasActivas();
}
