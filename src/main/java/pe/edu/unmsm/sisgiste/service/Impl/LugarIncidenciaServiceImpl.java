package pe.edu.unmsm.sisgiste.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.sisgiste.convertor.LugarIncidenciaConvertor;
import pe.edu.unmsm.sisgiste.entity.LugarIncidencia;
import pe.edu.unmsm.sisgiste.model.LugarIncidenciaModel;
import pe.edu.unmsm.sisgiste.repository.LugarIncidenciaRepository;
import pe.edu.unmsm.sisgiste.service.LugarIncidenciaService;

@Service
@Transactional
public class LugarIncidenciaServiceImpl implements LugarIncidenciaService {

	@Autowired
	LugarIncidenciaRepository lugIncRep;
	@Autowired
	LugarIncidenciaConvertor lugIncConvertor;

	@Override
	public List<LugarIncidenciaModel> obtenerLugaresIncidencia() {
		List<LugarIncidencia> LIList = lugIncRep.findAll();
		if (LIList != null){
			List<LugarIncidenciaModel> LIModelList = new ArrayList<LugarIncidenciaModel>();
			for(LugarIncidencia LI: LIList)
				LIModelList.add(lugIncConvertor.convertirDeEntityAModel(LI));
			return LIModelList;
		}
		else
			return null;
	}

	@Override
	public LugarIncidenciaModel obtenerLugarIncidenciarPorID(Integer ID) {
		LugarIncidencia LI=lugIncRep.findByIdLugarIncidencia(ID);
		return (LI==null)?null:lugIncConvertor.convertirDeEntityAModel(LI);
	}

}
