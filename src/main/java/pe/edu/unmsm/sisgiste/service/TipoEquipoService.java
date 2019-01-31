package pe.edu.unmsm.sisgiste.service;

import java.util.List;

import pe.edu.unmsm.sisgiste.model.TipoEquipoModel;

public interface TipoEquipoService {

	public abstract List<TipoEquipoModel> obtenerTiposEquipo();
	
	public abstract TipoEquipoModel obtenerTipoEquipoPorID(Integer ID);
}
