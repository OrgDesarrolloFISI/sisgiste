package pe.edu.unmsm.sisgiste.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.sisgiste.entity.Incidencia;
import pe.edu.unmsm.sisgiste.entity.Persona;
import pe.edu.unmsm.sisgiste.model.IncidenciaModel;
import pe.edu.unmsm.sisgiste.model.IncidenciaReporteModel;
import pe.edu.unmsm.sisgiste.repository.LugarIncidenciaRepository;
import pe.edu.unmsm.sisgiste.repository.TecnicoRepository;
import pe.edu.unmsm.sisgiste.repository.TipoEquipoRepository;

@Component
public class IncidenciaConvertor {

	@Autowired
	LugarIncidenciaRepository lugIncRep;
	@Autowired
	TecnicoRepository tecnicoRep;
	@Autowired
	TipoEquipoRepository tipoEquipoRep;

	public Incidencia convertirDeModelAEntity(IncidenciaModel IM) {
		Incidencia out = new Incidencia();
		out.setEstado(IM.getEstado());
		out.setIdIncidencia(IM.getIdIncidencia());
		out.setIncidenciaDescripcionSolucion(IM.getDescripcionSolucion());
		out.setIncidenciaFecha(IM.getFechaIncidencia());
		out.setIncidenciaHoraInicio(IM.getHoraInicio());
		out.setIncidenciaHoraFin(IM.getHoraFin());
		out.setIncidenciaUsuario(IM.getUsuario());
		out.setLugarIncidencia(lugIncRep.findByIdLugarIncidencia(IM.getIdLugarIncidencia()));
		out.setProblema(IM.getProblema());
		out.setSbn(IM.getSBN());
		out.setTecnicoByTecnicoIdTecnicoRecepcionista(
				tecnicoRep.findByIdTecnico(IM.getIdTecnicoRecepcionista()));
		out.setTecnicoByTecnicoIdTecnicoSolucionador(tecnicoRep.findByIdTecnico(IM.getIdTecnicoSolucionador()));
		out.setTipoEquipo(tipoEquipoRep.findByIdTipoEqupo(IM.getIdEquipo()));
		return out;
	}
	
	public IncidenciaModel convertirDeEntityAModel(Incidencia I) {
		IncidenciaModel out = new IncidenciaModel();
		out.setEstado(I.getEstado());
		out.setIdIncidencia(I.getIdIncidencia());
		out.setDescripcionSolucion(I.getIncidenciaDescripcionSolucion());
		out.setFechaIncidencia(I.getIncidenciaFecha());
		out.setHoraInicio(I.getIncidenciaHoraInicio());
		out.setHoraFin(I.getIncidenciaHoraFin());
		out.setUsuario(I.getIncidenciaUsuario());
		out.setIdLugarIncidencia(I.getLugarIncidencia().getIdLugarIncidencia());						//No debería se nulo
		out.setProblema(I.getProblema());
		out.setSBN(I.getSbn());
		out.setIdTecnicoRecepcionista(I.getTecnicoByTecnicoIdTecnicoRecepcionista().getIdTecnico());	//No debería se nulo
		if(I.getTecnicoByTecnicoIdTecnicoSolucionador()!=null)
			out.setIdTecnicoSolucionador(I.getTecnicoByTecnicoIdTecnicoSolucionador().getIdTecnico());
		if(I.getTipoEquipo()!=null)
			out.setIdEquipo(I.getTipoEquipo().getIdTipoEqupo());
		
		out.setNombreOficina(I.getLugarIncidencia().getLugarIncidenciaNombre());						//No debería se nulo
		
		Persona p = I.getTecnicoByTecnicoIdTecnicoRecepcionista().getPersona();							//No debería se nulo
		String nombreTecnicoRecepcionista=p.getPersonaAppaterno()+" "+p.getPersonaApmaterno()+", "+p.getPersonaNombre();
		out.setNombreTecnicoRecepcionista(nombreTecnicoRecepcionista);
		return out;
	}
	
	public IncidenciaReporteModel convertirEntityAReporteModel(Incidencia I){
		IncidenciaReporteModel reporteModel=new IncidenciaReporteModel();
		String [] fechaPartes= I.getIncidenciaFecha().toString().split("-");	//Formato: YYYY-mm-dd
		String fechaFinal=fechaPartes[2]+"/"+fechaPartes[1]+"/"+fechaPartes[0];	//Formato Nuevo: dd/mm/YYYY
		
		reporteModel.setFecha(fechaFinal);
		reporteModel.setLugarIncidencia(I.getLugarIncidencia().getLugarIncidenciaNombre());
		reporteModel.setProblema(I.getProblema());
		reporteModel.setSolucion(I.getIncidenciaDescripcionSolucion());
		
		return reporteModel;
	}
}
