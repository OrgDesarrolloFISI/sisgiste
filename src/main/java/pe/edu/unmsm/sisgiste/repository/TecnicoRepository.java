package pe.edu.unmsm.sisgiste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.unmsm.sisgiste.entity.Tecnico;
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer>{

	public Tecnico findByIdTecnico(Integer ID);
	
	@Query("SELECT T FROM Tecnico as T WHERE T.tecnicoActivo = '1'")
	public List<Tecnico> findTecnicosActivos();
}
