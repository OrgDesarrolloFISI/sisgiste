package pe.edu.sistemas.sisgiste.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisgiste.convertor.IncidenciaConvertor;
import pe.edu.sistemas.sisgiste.entity.Incidencia;
import pe.edu.sistemas.sisgiste.model.IncidenciaModel;
import pe.edu.sistemas.sisgiste.model.IncidenciaReporteModel;
import pe.edu.sistemas.sisgiste.repository.IncidenciaRepository;
import pe.edu.sistemas.sisgiste.service.IncidenciaService;
import pe.edu.sistemas.sisgiste.util.Tiempo;

@Service
@Transactional
public class IncidenciaServiceImpl implements IncidenciaService {

	@Autowired
	IncidenciaRepository incidenciaRepo;
	@Autowired
	IncidenciaConvertor incidenciaConvertor;
	@Autowired
	Tiempo tiempo;

	@Override
	public IncidenciaModel guardarIncidencia(IncidenciaModel incidenciaModel) {
		Date FechaYHoraInicio = tiempo.obtenerFechaYHoraActual();

		Incidencia I = incidenciaConvertor.convertirDeModelAEntity(incidenciaModel);
		I.setEstado("1");
		I.setIncidenciaFecha(FechaYHoraInicio);
		I.setIncidenciaHoraInicio(FechaYHoraInicio);
		Incidencia IExito = incidenciaRepo.save(I);

		return (IExito == null) ? null : incidenciaConvertor.convertirDeEntityAModel(IExito);
	}

	@Override
	public IncidenciaModel actualizarIncidencia(IncidenciaModel incidenciaModel) {
		Date HoraFin = tiempo.obtenerFechaYHoraActual();

		Incidencia Iaux = incidenciaRepo.findByIdIncidencia(incidenciaModel.getIdIncidencia());

		incidenciaModel.setFechaIncidencia(Iaux.getIncidenciaFecha());
		incidenciaModel.setHoraInicio(Iaux.getIncidenciaHoraInicio());

		Incidencia I = incidenciaConvertor.convertirDeModelAEntity(incidenciaModel);

		I.setIncidenciaHoraFin(HoraFin);
		I.setEstado("0");
		Incidencia IExito = incidenciaRepo.save(I);

		return (IExito == null) ? null : incidenciaConvertor.convertirDeEntityAModel(IExito);
	}

	@Override
	public Integer obtenerUltimaIncidencia() {
		Incidencia i = incidenciaRepo.findFirstByOrderByIdIncidenciaDesc();
		if (i == null)
			return 0;
		else
			return i.getIdIncidencia();
	}

	@Override
	public List<IncidenciaModel> obtenerIncidenciasActivas() {
		List<Incidencia> incidencias = incidenciaRepo.findIncidenciasActivas();
		if (incidencias != null) {
			List<IncidenciaModel> IMList = new ArrayList<IncidenciaModel>();
			for (Incidencia i : incidencias)
				IMList.add(incidenciaConvertor.convertirDeEntityAModel(i));
			return IMList;
		} else {
			return null;
		}
	}

	@Override
	public List<IncidenciaReporteModel> obtenerIncidenciasPorIdTecnico(Integer idTecnico) {
		List<IncidenciaReporteModel> incidenciaReporteLista = new ArrayList<IncidenciaReporteModel>();
		List<Incidencia> incidencias = incidenciaRepo.findIncidenciasConcluidasPorIdTecnico(idTecnico);
		for (Incidencia I : incidencias) {
			incidenciaReporteLista.add(incidenciaConvertor.convertirEntityAReporteModel(I));
		}
		return incidenciaReporteLista;
	}

	@Override
	public List<IncidenciaReporteModel> obtenerIncidenciasPorIdTecnicoPorFechasInicioFin(String idTecnico,
			String fechaInicio, String fechaFin) {
		List<IncidenciaReporteModel> incidenciaReporteLista = new ArrayList<IncidenciaReporteModel>();
		List<Incidencia> incidencias = incidenciaRepo.findIncidenciasConcluidasPorIdTecnicoEntreFechas(
				Integer.parseInt(idTecnico), tiempo.obtenerFechaDeString(fechaInicio),
				tiempo.obtenerFechaDeString(fechaFin));
		for (Incidencia I : incidencias) {
			incidenciaReporteLista.add(incidenciaConvertor.convertirEntityAReporteModel(I));
		}
		return incidenciaReporteLista;
	}

	@Override
	public List<IncidenciaReporteModel> obtenerIncidenciasPorProblemaYLugarIncidenciaYEquipo(String problema,
			String idLugarIncidencia, String idEquipo) {
		List<IncidenciaReporteModel> incidenciaReporteLista = new ArrayList<IncidenciaReporteModel>();
		problema = "%" + problema + "%";
		List<Incidencia> incidencias=new ArrayList<>();
		if (idLugarIncidencia.equals("-1")) { // -1 significa no ha eligido
												// oficinas
			if (idEquipo.equals("-1")) { // -1 significa no ha eligido tipo
											// equipo
				incidencias = incidenciaRepo.findbyLikeProblema(problema);
				
			} else { // Ha elegido tipo de equipo pero no lugar de incidencias
				incidencias = incidenciaRepo.findbyLikeProblemaAndEquipoId(problema,
						Integer.parseInt(idEquipo));
			}
			
		} else { // Ha elegido lugar de incidencias
			if (idEquipo.equals("-1")) { // Ha elegido lugar de incidencia pero
											// no ha elegido tipo equipo
				incidencias = incidenciaRepo.findbyLikeProblemaAndOficinaId(problema,
						Integer.parseInt(idLugarIncidencia));
				
			} else { // Ha elegido lugar de incidencia y tipo de equipo
				incidencias = incidenciaRepo.findbyLikeProblemaAndLugarIncidenciaIdAndEquipoId(
						problema, Integer.parseInt(idLugarIncidencia), Integer.parseInt(idEquipo));
			}
			
		}
		for (Incidencia I : incidencias) {
			incidenciaReporteLista.add(incidenciaConvertor.convertirEntityAReporteModel(I));
		}
		return incidenciaReporteLista;
	}

}
