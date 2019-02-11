package pe.edu.sistemas.sisgiste.convertor;

import org.springframework.stereotype.Component;

import pe.edu.sistemas.sisgiste.entity.TipoEquipo;
import pe.edu.sistemas.sisgiste.model.TipoEquipoModel;

@Component
public class TipoEquipoConvertor {

	public TipoEquipoModel convertirDeEntityAModel(TipoEquipo TE) {
		TipoEquipoModel out = new TipoEquipoModel();
		out.setIdTipoEquipo(TE.getIdTipoEqupo());
		out.setNombreTipoEquipo(TE.getEquipoDsecripcion());
		return out;
	}
	
}
