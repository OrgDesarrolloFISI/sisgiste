package pe.edu.unmsm.sisgiste.convertor;

import org.springframework.stereotype.Component;

import pe.edu.unmsm.sisgiste.entity.Tecnico;
import pe.edu.unmsm.sisgiste.model.TecnicoModel;

@Component
public class TecnicoConvertor {

	public TecnicoModel convertirDeEntityAModel(Tecnico T) {
		TecnicoModel out = new TecnicoModel();
		out.setIdTecnico(T.getIdTecnico());
		String nombreCompleto = T.getPersona().getPersonaAppaterno() + " " + T.getPersona().getPersonaApmaterno() + ", "
				+ T.getPersona().getPersonaNombre();
		out.setNombreCompleto(nombreCompleto);
		return out;
	}
}
