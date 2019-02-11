package pe.edu.sistemas.sisgiste.service;

import java.util.List;

import pe.edu.sistemas.sisgiste.model.TecnicoModel;

public interface TecnicoService {

	public TecnicoModel encontrarTecnicoPorID(Integer ID);
	public List<TecnicoModel> obtenerTecnicos();
}
