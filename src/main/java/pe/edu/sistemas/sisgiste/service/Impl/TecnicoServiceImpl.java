package pe.edu.sistemas.sisgiste.service.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisgiste.convertor.TecnicoConvertor;
import pe.edu.sistemas.sisgiste.entity.Incidencia;
import pe.edu.sistemas.sisgiste.entity.Tecnico;
import pe.edu.sistemas.sisgiste.model.TecnicoModel;
import pe.edu.sistemas.sisgiste.repository.TecnicoRepository;
import pe.edu.sistemas.sisgiste.service.TecnicoService;
import pe.edu.sistemas.sisgiste.util.Tiempo;

@Service
@Transactional
public class TecnicoServiceImpl implements TecnicoService {

	@Autowired
	TecnicoRepository tecnicoRepo;
	@Autowired
	TecnicoConvertor tecnicoConvertor;
	@Autowired
	Tiempo tiempo;

	@Override
	public List<TecnicoModel> obtenerTecnicos() {
		List<Tecnico> TList = tecnicoRepo.findTecnicosActivos();
		if (TList != null) {
			List<TecnicoModel> TMList = new ArrayList<TecnicoModel>();
			for (Tecnico T : TList)
				TMList.add(tecnicoConvertor.convertirDeEntityAModel(T));
			return TMList;
		} else
			return null;
	}

	@Override
	public TecnicoModel encontrarTecnicoPorID(Integer ID) {
		Tecnico T = tecnicoRepo.findByIdTecnico(ID);
		return (T == null) ? null : tecnicoConvertor.convertirDeEntityAModel(T);
	}

	@Override
	public List<TecnicoModel> obtenerTecnicosConServiciosEntreFechas(String fechaInicio, String fechaFin) {
		List<Tecnico> TList = tecnicoRepo.findTecnicosActivos();
		Date dateFechaInicio = tiempo.obtenerFechaComenzandoDiaDeString(fechaInicio);
		Date dateFechaFin = tiempo.obtenerFechaAcabandoDiaDeString(fechaFin);
		long errorMili = 978;	//Al usar el tipo de dato DATE de MySQL, 
								//este no le asigna valor y se diferencia en 978 milisegundos 
								//con un Date de Java normal
		if (TList != null) {
			List<TecnicoModel> TMList = new ArrayList<TecnicoModel>();
			Tecnico aux;
			int contadorIncidencias;
			for (int i = 0; i < TList.size(); i++) {
				contadorIncidencias = 0;
				aux = TList.get(i);
				for (Incidencia I : aux.getIncidenciasForTecnicoIdTecnicoSolucionador()) {
					if (I.getIncidenciaFecha().getTime()>=dateFechaInicio.getTime()-errorMili
							&& I.getIncidenciaFecha().getTime()<=dateFechaFin.getTime()-errorMili ) { // Si está dentro del rango
						contadorIncidencias++;
					}
				}
				TecnicoModel TM = tecnicoConvertor.convertirDeEntityAModel(TList.get(i));
				TM.setIncidenciasAtendidas(contadorIncidencias);
				TMList.add(TM);
			}
			Collections.sort(TMList);
			return TMList;
		}
		return null;
	}

}
