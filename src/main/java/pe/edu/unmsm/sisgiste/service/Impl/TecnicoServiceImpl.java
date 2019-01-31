package pe.edu.unmsm.sisgiste.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.sisgiste.convertor.TecnicoConvertor;
import pe.edu.unmsm.sisgiste.entity.Tecnico;
import pe.edu.unmsm.sisgiste.model.TecnicoModel;
import pe.edu.unmsm.sisgiste.repository.TecnicoRepository;
import pe.edu.unmsm.sisgiste.service.TecnicoService;

@Service
@Transactional
public class TecnicoServiceImpl implements TecnicoService {

	@Autowired
	TecnicoRepository tecnicoRepo;
	@Autowired
	TecnicoConvertor tecnicoConvertor;

	@Override
	public List<TecnicoModel> obtenerTecnicos() {
		List<Tecnico> TList = tecnicoRepo.findTecnicosActivos();
		if (TList != null) {
			List<TecnicoModel> TMList = new ArrayList<TecnicoModel>();
			for (Tecnico T : TList)
				TMList.add(tecnicoConvertor.convertirDeEntityAModel(T));
			return TMList;
		}
		else
			return null;
	}

	@Override
	public TecnicoModel encontrarTecnicoPorID(Integer ID) {
		Tecnico T = tecnicoRepo.findByIdTecnico(ID);
		return (T==null)?null:tecnicoConvertor.convertirDeEntityAModel(T);
	}

}
