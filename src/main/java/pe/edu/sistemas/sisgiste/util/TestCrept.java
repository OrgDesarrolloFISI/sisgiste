package pe.edu.sistemas.sisgiste.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class TestCrept {

	public static void main(String[] args) {

		Md5PasswordEncoder codificador = new Md5PasswordEncoder();
		String contraseña= "15200053";
		System.out.println(codificador.encodePassword(contraseña, ""));
		
	}

}
