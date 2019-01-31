package pe.edu.unmsm.sisgiste.service;

import java.util.List;

import pe.edu.unmsm.sisgiste.model.IncidenciaModel;

public interface IncidenciaService {
	public abstract IncidenciaModel guardarIncidencia(IncidenciaModel incidenciaModel);
	public abstract IncidenciaModel actualizarIncidencia(IncidenciaModel incidenciaModel);
	public abstract Integer obtenerUltimaIncidencia();
	public abstract List<IncidenciaModel> obtenerIncidenciasActivas();
}
