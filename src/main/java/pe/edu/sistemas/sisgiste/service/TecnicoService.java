package pe.edu.sistemas.sisgiste.service;

import java.util.List;

import pe.edu.sistemas.sisgiste.model.TecnicoModel;

public interface TecnicoService {

	public abstract TecnicoModel encontrarTecnicoPorID(Integer ID);
	public abstract List<TecnicoModel> obtenerTecnicos();
	public abstract List<TecnicoModel> obtenerTecnicosConServiciosEntreFechas(String fechaInicio, String fechaFin);
}
