package pe.edu.sistemas.sisgiste.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisgiste.entity.Incidencia;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {

	public Incidencia findByIdIncidencia(Integer idIncidencia);

	public Incidencia findFirstByOrderByIdIncidenciaDesc();

	@Query("SELECT I from Incidencia as I WHERE I.estado= '1'")
	public List<Incidencia> findIncidenciasActivas();

	@Query("SELECT I from Incidencia as I WHERE I.estado= '0' AND I.tecnicoByTecnicoIdTecnicoSolucionador.idTecnico= :idTecnico")
	public List<Incidencia> findIncidenciasConcluidasPorIdTecnico(@Param(value = "idTecnico") Integer idTecnico);

	@Query("SELECT I from Incidencia as I WHERE I.estado= '0' AND I.tecnicoByTecnicoIdTecnicoSolucionador.idTecnico= :idTecnico "
			+ "AND I.incidenciaFecha>= :fechaInicio AND I.incidenciaFecha <= :fechaFin")
	public List<Incidencia> findIncidenciasConcluidasPorIdTecnicoEntreFechas(
			@Param(value = "idTecnico") Integer idTecnico, @Param(value = "fechaInicio") Date fechaInicio,
			@Param(value = "fechaFin") Date fechaFin);
}
