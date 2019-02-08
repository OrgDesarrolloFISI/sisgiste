package pe.edu.unmsm.sisgiste.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Configuration
public class JasperConfiguration {
	
	@Bean
	@Qualifier(value="ReporteBolsista")
	public JasperReportsPdfView getPlantillaPDF() {
	  JasperReportsPdfView view = new JasperReportsPdfView();
	  view.setUrl("classpath:/reportes/ReporteBolsista.jrxml");
	  view.setReportDataKey("datasource");
	  return view;
	}
}
