package pe.edu.unmsm.sisgiste;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.sisgiste.model.TipoEquipoModel;
import pe.edu.unmsm.sisgiste.service.TipoEquipoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TipoEquipoTest {

	@Autowired
	TipoEquipoService tipoEquipoService;
	
	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void mostrarTodoTipoEquipo(){
		List<TipoEquipoModel> TEList = tipoEquipoService.obtenerTiposEquipo();
		for(TipoEquipoModel TEM : TEList)
			System.out.println(TEM);
	}
	
	@Test
	public void mostrarTipoEquipoPorID(){
		TipoEquipoModel TEM = tipoEquipoService.obtenerTipoEquipoPorID(2);
		System.out.println(TEM);
	}

}
