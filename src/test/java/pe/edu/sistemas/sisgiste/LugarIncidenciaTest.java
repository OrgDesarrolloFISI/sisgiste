package pe.edu.sistemas.sisgiste;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisgiste.model.LugarIncidenciaModel;
import pe.edu.sistemas.sisgiste.service.LugarIncidenciaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LugarIncidenciaTest {

	@Autowired
	LugarIncidenciaService lugarIncidenciaServ;
	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void obtenerLugaresIncidencia(){
		List<LugarIncidenciaModel> LIList=lugarIncidenciaServ.obtenerLugaresIncidencia();
		for (LugarIncidenciaModel LIM : LIList)
			System.out.println(LIM);
	}
	
	@Test
	public void obtenerLugarIncidenciaPorId(){
		LugarIncidenciaModel LIM = lugarIncidenciaServ.obtenerLugarIncidenciarPorID(45);
		System.out.println(LIM);
	}
	
}
