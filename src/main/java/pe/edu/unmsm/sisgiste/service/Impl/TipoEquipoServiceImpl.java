package pe.edu.unmsm.sisgiste.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.sisgiste.convertor.TipoEquipoConvertor;
import pe.edu.unmsm.sisgiste.entity.TipoEquipo;
import pe.edu.unmsm.sisgiste.model.TipoEquipoModel;
import pe.edu.unmsm.sisgiste.repository.TipoEquipoRepository;
import pe.edu.unmsm.sisgiste.service.TipoEquipoService;

@Service
@Transactional
public class TipoEquipoServiceImpl implements TipoEquipoService{

	@Autowired TipoEquipoRepository tipoEquipoRepo;
	@Autowired TipoEquipoConvertor tipoEquipoConvertor;
	@Override
	public List<TipoEquipoModel> obtenerTiposEquipo() {
		List<TipoEquipo> TEList = tipoEquipoRepo.findAll();
		if (TEList != null) {
			List<TipoEquipoModel> TMList = new ArrayList<TipoEquipoModel>();
			for (TipoEquipo TE : TEList)
				TMList.add(tipoEquipoConvertor.convertirDeEntityAModel(TE));
			return TMList;
		}
		else
			return null;
	}

	@Override
	public TipoEquipoModel obtenerTipoEquipoPorID(Integer ID) {
		TipoEquipo TE = tipoEquipoRepo.findByIdTipoEqupo(ID);
		return (TE==null)?null:tipoEquipoConvertor.convertirDeEntityAModel(TE);
	}

}
