package pe.edu.unmsm.sisgiste.convertor;

import org.springframework.stereotype.Component;

import pe.edu.unmsm.sisgiste.entity.LugarIncidencia;
import pe.edu.unmsm.sisgiste.model.LugarIncidenciaModel;

@Component
public class LugarIncidenciaConvertor {
	
	public LugarIncidenciaModel convertirDeEntityAModel(LugarIncidencia LI) {
		LugarIncidenciaModel out = new LugarIncidenciaModel();
		out.setIdLugarIncidencia(LI.getIdLugarIncidencia());
		out.setNombreLugarIncidencia(LI.getLugarIncidenciaNombre());
		return out;
	}
}
