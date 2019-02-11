package pe.edu.sistemas.sisgiste.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisgiste.convertor.TipoEquipoConvertor;
import pe.edu.sistemas.sisgiste.entity.TipoEquipo;
import pe.edu.sistemas.sisgiste.model.TipoEquipoModel;
import pe.edu.sistemas.sisgiste.repository.TipoEquipoRepository;
import pe.edu.sistemas.sisgiste.service.TipoEquipoService;

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
