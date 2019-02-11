package pe.edu.sistemas.sisgiste.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisgiste.convertor.LugarIncidenciaConvertor;
import pe.edu.sistemas.sisgiste.entity.LugarIncidencia;
import pe.edu.sistemas.sisgiste.model.LugarIncidenciaModel;
import pe.edu.sistemas.sisgiste.repository.LugarIncidenciaRepository;
import pe.edu.sistemas.sisgiste.service.LugarIncidenciaService;

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
