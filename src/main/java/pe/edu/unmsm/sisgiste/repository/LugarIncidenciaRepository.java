package pe.edu.unmsm.sisgiste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.unmsm.sisgiste.entity.LugarIncidencia;
@Repository
public interface LugarIncidenciaRepository extends JpaRepository<LugarIncidencia,Integer>{
	public LugarIncidencia findByIdLugarIncidencia(Integer ID);
}
