package pe.edu.sistemas.sisgiste.service;

import java.util.List;

import pe.edu.sistemas.sisgiste.model.TipoEquipoModel;

public interface TipoEquipoService {

	public abstract List<TipoEquipoModel> obtenerTiposEquipo();
	
	public abstract TipoEquipoModel obtenerTipoEquipoPorID(Integer ID);
}
