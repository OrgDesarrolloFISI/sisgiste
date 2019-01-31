package pe.edu.unmsm.sisgiste.convertor;

import org.springframework.stereotype.Component;

import pe.edu.unmsm.sisgiste.entity.TipoEquipo;
import pe.edu.unmsm.sisgiste.model.TipoEquipoModel;

@Component
public class TipoEquipoConvertor {

	public TipoEquipoModel convertirDeEntityAModel(TipoEquipo TE) {
		TipoEquipoModel out = new TipoEquipoModel();
		out.setIdTipoEquipo(TE.getIdTipoEqupo());
		out.setNombreTipoEquipo(TE.getEquipoDsecripcion());
		return out;
	}
	
}
