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

import pe.edu.sistemas.sisgiste.entity.Tecnico;
import pe.edu.sistemas.sisgiste.model.TecnicoModel;
import pe.edu.sistemas.sisgiste.repository.TecnicoRepository;
import pe.edu.sistemas.sisgiste.service.TecnicoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TecnicoTest {

	@Autowired TecnicoService tecnicoService;
	@Autowired TecnicoRepository tecnicoRepository;
	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void obtenerTecnicosModel(){
		List<TecnicoModel> TMList = tecnicoService.obtenerTecnicos();
		for(TecnicoModel TM : TMList)
			System.out.println(TM);
	}
	
	@Test
	@Ignore
	public void obtenerTecnicoPorID(){
		TecnicoModel TM = tecnicoService.encontrarTecnicoPorID(2);
		System.out.println(TM);
	}
	
	@Test
	public void obtenerTecnicosMerito(){
		List<TecnicoModel> TMList = tecnicoService.obtenerTecnicosConServiciosEntreFechas("27/01/2019", "31/01/2019");
		for(TecnicoModel TM : TMList )
			System.out.println(TM);
	}

}
