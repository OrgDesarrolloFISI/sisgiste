package pe.edu.sistemas.sisgiste;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisgiste.util.Tiempo;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TiempoTest {

	@Autowired Tiempo tiempo;
	
	@Test
	public void mostrarTiempoActual(){
		System.out.println(tiempo.obtenerFechaActual());
	}
}
