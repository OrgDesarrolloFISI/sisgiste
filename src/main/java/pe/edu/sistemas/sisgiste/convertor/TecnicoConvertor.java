package pe.edu.sistemas.sisgiste.convertor;

import org.springframework.stereotype.Component;

import pe.edu.sistemas.sisgiste.entity.Tecnico;
import pe.edu.sistemas.sisgiste.model.TecnicoModel;

@Component
public class TecnicoConvertor {

	public TecnicoModel convertirDeEntityAModel(Tecnico T) {
		TecnicoModel out = new TecnicoModel();
		out.setIdTecnico(T.getIdTecnico());
		String nombreCompleto = T.getPersona().getPersonaNombre() + " " + T.getPersona().getPersonaAppaterno() + " "
				+ T.getPersona().getPersonaApmaterno();
		out.setNombreCompleto(nombreCompleto);
		return out;
	}
}
