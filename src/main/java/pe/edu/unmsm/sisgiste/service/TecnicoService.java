package pe.edu.unmsm.sisgiste.service;

import java.util.List;

import pe.edu.unmsm.sisgiste.model.TecnicoModel;

public interface TecnicoService {

	public TecnicoModel encontrarTecnicoPorID(Integer ID);
	public List<TecnicoModel> obtenerTecnicos();
}
