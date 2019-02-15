package pe.edu.sistemas.sisgiste.service;

import java.util.List;

import pe.edu.sistemas.sisgiste.model.IncidenciaModel;
import pe.edu.sistemas.sisgiste.model.IncidenciaReporteModel;

public interface IncidenciaService {
	public abstract IncidenciaModel guardarIncidencia(IncidenciaModel incidenciaModel);
	public abstract IncidenciaModel actualizarIncidencia(IncidenciaModel incidenciaModel);
	public abstract Integer obtenerUltimaIncidencia();
	public abstract List<IncidenciaModel> obtenerIncidenciasActivas();
	public abstract List<IncidenciaReporteModel> obtenerIncidenciasPorIdTecnico(Integer idTecnico);
	public abstract List<IncidenciaReporteModel> obtenerIncidenciasPorIdTecnicoPorFechasInicioFin(String idTecnico, String fechaInicio, String fechaFin);
	public abstract List<IncidenciaReporteModel> obtenerIncidenciasPorProblemaYLugarIncidenciaYEquipo(String problema, String idLugarIncidencia, String idEquipo);
}
