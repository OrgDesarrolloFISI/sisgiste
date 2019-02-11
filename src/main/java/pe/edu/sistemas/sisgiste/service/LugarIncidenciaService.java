package pe.edu.sistemas.sisgiste.service;

import java.util.List;

import pe.edu.sistemas.sisgiste.model.LugarIncidenciaModel;

public interface LugarIncidenciaService {
	public abstract List<LugarIncidenciaModel> obtenerLugaresIncidencia();
	public abstract LugarIncidenciaModel obtenerLugarIncidenciarPorID(Integer ID);
}
