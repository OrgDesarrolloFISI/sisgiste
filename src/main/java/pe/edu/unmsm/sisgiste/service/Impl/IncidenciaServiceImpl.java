package pe.edu.unmsm.sisgiste.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.sisgiste.convertor.IncidenciaConvertor;
import pe.edu.unmsm.sisgiste.entity.Incidencia;
import pe.edu.unmsm.sisgiste.model.IncidenciaModel;
import pe.edu.unmsm.sisgiste.repository.IncidenciaRepository;
import pe.edu.unmsm.sisgiste.service.IncidenciaService;
import pe.edu.unmsm.sisgiste.util.Tiempo;

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

}
