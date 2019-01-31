package pe.edu.unmsm.sisgiste.service;

import java.util.List;

import pe.edu.unmsm.sisgiste.model.LugarIncidenciaModel;

public interface LugarIncidenciaService {
	public abstract List<LugarIncidenciaModel> obtenerLugaresIncidencia();
	public abstract LugarIncidenciaModel obtenerLugarIncidenciarPorID(Integer ID);
}
