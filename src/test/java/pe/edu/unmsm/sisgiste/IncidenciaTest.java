package pe.edu.unmsm.sisgiste;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.sisgiste.model.IncidenciaModel;
import pe.edu.unmsm.sisgiste.service.IncidenciaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class IncidenciaTest {

	@Autowired
	IncidenciaService incidenciaServ;
	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void obtenerUltimaIncidencia(){
		System.out.println(incidenciaServ.obtenerUltimaIncidencia()); 
	}
	
	@Test
	public void obtenerIncidenciasActivas(){
		List<IncidenciaModel> IMList=incidenciaServ.obtenerIncidenciasActivas();
		for (IncidenciaModel IM : IMList)
			System.out.println(IM);
	}
	
	@Test
	@Ignore
	public void guardarIncidencia(){
		IncidenciaModel IM = new IncidenciaModel();
		IM.setEstado("1");
		//IM.setIdIncidencia();
		IM.setDescripcionSolucion(null);
		IM.setFechaIncidencia(new Date(119,0,29));
		IM.setHoraInicio(new Date(System.currentTimeMillis()));
		//IM.setHoraFin(I.getIncidenciaHoraFin());
		//IM.setUsuario(I.getIncidenciaUsuario());
		IM.setIdLugarIncidencia(45);
		//IM.setProblema(I.getProblema());
		//IM.setSBN(I.getSbn());
		IM.setIdTecnicoRecepcionista(1);
		//IM.setIdTecnicoSolucionador(I.getTecnicoByTecnicoIdTecnicoSolucionador().getIdTecnico());
		IM.setIdEquipo(3);
		System.out.println(incidenciaServ.guardarIncidencia(IM));
	}
	
	@Test
	@Ignore
	public void actualizarIncidencia(){
		IncidenciaModel IM = new IncidenciaModel();
		IM.setEstado("1");
		//IM.setIdIncidencia();
		IM.setDescripcionSolucion(null);
		IM.setFechaIncidencia(new Date(119,0,28));
		IM.setHoraInicio(new Date(System.currentTimeMillis()));
		//IM.setHoraFin(I.getIncidenciaHoraFin());
		//IM.setUsuario(I.getIncidenciaUsuario());
		IM.setIdLugarIncidencia(47);
		//IM.setProblema(I.getProblema());
		//IM.setSBN(I.getSbn());
		IM.setIdTecnicoRecepcionista(2);
		//IM.setIdTecnicoSolucionador(I.getTecnicoByTecnicoIdTecnicoSolucionador().getIdTecnico());
		IM.setIdEquipo(4);
		System.out.println(incidenciaServ.actualizarIncidencia(IM));
	}
	
	
}
