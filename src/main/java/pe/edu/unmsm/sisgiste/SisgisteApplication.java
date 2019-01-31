package pe.edu.unmsm.sisgiste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SisgisteApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SisgisteApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SisgisteApplication.class, args);
	}
	
}

