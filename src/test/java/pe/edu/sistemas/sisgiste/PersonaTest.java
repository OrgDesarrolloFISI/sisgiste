package pe.edu.sistemas.sisgiste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisgiste.entity.Persona;
import pe.edu.sistemas.sisgiste.entity.Usuario;
import pe.edu.sistemas.sisgiste.repository.PersonaRepository;
import pe.edu.sistemas.sisgiste.repository.UsuarioRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class PersonaTest {

	@Autowired PersonaRepository personaRepository;
	@Autowired UsuarioRepository usuarioRepository;
	
	@Test
	@Ignore
	public void buscarPersonaPorCodigo() {
		Persona p = personaRepository.findByPersonaCodigoSistema("15200053");
		System.out.println(p.getPersonaAppaterno()+" "+p.getPersonaApmaterno()+", "+p.getPersonaNombre());
	}
	
	@Test
	public void buscarRolesDelSistema() {
		List<Usuario> roles = usuarioRepository.findByCodigoPersona("15200053");
		for(Usuario u : roles) {
			System.out.println(u.getTipoUsuario().getNombreTipoUsuario());
		}
	}
}
