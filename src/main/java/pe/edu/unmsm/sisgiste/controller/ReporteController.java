package pe.edu.unmsm.sisgiste.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pe.edu.unmsm.sisgiste.model.BusquedaReporte;
import pe.edu.unmsm.sisgiste.model.IncidenciaReporteModel;
import pe.edu.unmsm.sisgiste.model.TecnicoModel;
import pe.edu.unmsm.sisgiste.service.IncidenciaService;
import pe.edu.unmsm.sisgiste.service.TecnicoService;

@Controller
public class ReporteController {
	final String nombreArchivo= "ReporteBolsista";
	
	@Autowired IncidenciaService incidenciaService;
	@Autowired TecnicoService tecnicoService;
	
	@Autowired
	@Qualifier(value=nombreArchivo)
	JasperReportsPdfView reporteBolsista;
	
	
	
	@RequestMapping("/reportes")
	public ModelAndView vistaReporte(){
		ModelAndView MAV = new ModelAndView("soporte/reportes");
		MAV.addObject("busquedaReporte", new BusquedaReporte());
		MAV.addObject("listaTecnicos", tecnicoService.obtenerTecnicos());
		return MAV;
	}
	
	@PostMapping("/reporteImprimir")
	public ModelAndView verReporte(@ModelAttribute(name="busquedaReporte") BusquedaReporte busquedaReporte) throws IOException{
		Map<String,Object> mapaParametros= new HashMap<>();
		List<IncidenciaReporteModel> incidencias=incidenciaService.obtenerIncidenciasPorIdTecnicoPorFechasInicioFin(busquedaReporte.getIdTecnico(), busquedaReporte.getFechaInicioBusqueda(), busquedaReporte.getFechaFinBusqueda());
		TecnicoModel T = tecnicoService.encontrarTecnicoPorID(Integer.parseInt(busquedaReporte.getIdTecnico()));
		mapaParametros.put("datasource", new JRBeanCollectionDataSource(incidencias,false));
		mapaParametros.put("nombreBolsista", T.getNombreCompleto());
		return new ModelAndView(reporteBolsista, mapaParametros);
	}
}