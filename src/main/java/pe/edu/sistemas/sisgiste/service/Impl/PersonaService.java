package pe.edu.sistemas.sisgiste.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisgiste.entity.Persona;
import pe.edu.sistemas.sisgiste.entity.Usuario;
import pe.edu.sistemas.sisgiste.repository.PersonaRepository;
import pe.edu.sistemas.sisgiste.repository.UsuarioRepository;

@Service
public class PersonaService implements UserDetailsService{

	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Persona p = personaRepository.findByPersonaCodigoSistema(username);
		List<Usuario> roles = usuarioRepository.findByCodigoPersona(username);
		List<GrantedAuthority> autoridades=buildAuthorities(roles);
		
		User usuario=buildUser(p,autoridades);
		return usuario;
	}

	public User buildUser(Persona persona, List<GrantedAuthority> authorities) {
		User usuarioSecurity= new User(persona.getPersonaCodigoSistema(),persona.getPersonaPasswordSistema(), true,true,true,true,authorities);
		return usuarioSecurity;
	}
	
	public List<GrantedAuthority> buildAuthorities(List<Usuario> rolUsuario){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Usuario u : rolUsuario) {
			authorities.add(new SimpleGrantedAuthority(u.getTipoUsuario().getNombreTipoUsuario()));
		}
		return authorities;
	}
}
