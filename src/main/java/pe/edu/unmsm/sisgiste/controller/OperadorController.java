package pe.edu.unmsm.sisgiste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.unmsm.sisgiste.model.IncidenciaModel;
import pe.edu.unmsm.sisgiste.service.IncidenciaService;
import pe.edu.unmsm.sisgiste.service.LugarIncidenciaService;
import pe.edu.unmsm.sisgiste.service.TecnicoService;
import pe.edu.unmsm.sisgiste.service.TipoEquipoService;
import pe.edu.unmsm.sisgiste.util.Tiempo;

@Controller
public class OperadorController {

	@Autowired Tiempo tiempo;
	@Autowired IncidenciaService incidenciaService;
	@Autowired TecnicoService tecnicoService;
	@Autowired LugarIncidenciaService lugarIncidenciaService;
	@Autowired TipoEquipoService tipoEquipoService;
	
	@RequestMapping("/")
	public String redirectoperador(){
		return "redirect:/operador";
	}
	
	@RequestMapping("/operador")
	public String operador(Model model){
		String fechaActual=tiempo.obtenerFechaActual();
		IncidenciaModel IM= new IncidenciaModel();
		int ultimaincidencia=incidenciaService.obtenerUltimaIncidencia()+1;
		IM.setIdIncidencia(ultimaincidencia);
		
		model.addAttribute("fechaActual", fechaActual);
		model.addAttribute("incidencia",IM);
		model.addAttribute("IDIncidencia", ultimaincidencia);
		model.addAttribute("listaTecnicos", tecnicoService.obtenerTecnicos());
		model.addAttribute("listaLugaresIncidencia",lugarIncidenciaService.obtenerLugaresIncidencia());
		model.addAttribute("listaEquipos", tipoEquipoService.obtenerTiposEquipo());
		model.addAttribute("listaIncidencias", incidenciaService.obtenerIncidenciasActivas());
		
		return "operador";
	}
	
	@PostMapping("/registrarIncidencia")
	public String registrarIncidencia(@ModelAttribute("incidencia") IncidenciaModel IM){
		System.out.println("IM Recibido para guardar: "+IM);
		IncidenciaModel IMGuardado = incidenciaService.guardarIncidencia(IM);
		//System.out.println(IMGuardado);
		return "redirect:/operador";
	}
	
	@PostMapping("/actualizarIncidencia")
	public String actualizarIncidencia(@ModelAttribute("incidencia") IncidenciaModel IM){
		System.out.println("IM Recibido para actualizar: "+IM);
		incidenciaService.actualizarIncidencia(IM);
		return "redirect:/operador";
	}
}
