package pe.edu.unmsm.sisgiste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.unmsm.sisgiste.entity.TipoEquipo;
@Repository
public interface TipoEquipoRepository extends JpaRepository<TipoEquipo,Integer>{

	public TipoEquipo findByIdTipoEqupo(Integer ID);
}
