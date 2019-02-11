package pe.edu.sistemas.sisgiste.convertor;

import org.springframework.stereotype.Component;

import pe.edu.sistemas.sisgiste.entity.LugarIncidencia;
import pe.edu.sistemas.sisgiste.model.LugarIncidenciaModel;

@Component
public class LugarIncidenciaConvertor {
	
	public LugarIncidenciaModel convertirDeEntityAModel(LugarIncidencia LI) {
		LugarIncidenciaModel out = new LugarIncidenciaModel();
		out.setIdLugarIncidencia(LI.getIdLugarIncidencia());
		out.setNombreLugarIncidencia(LI.getLugarIncidenciaNombre());
		return out;
	}
}
