package pe.edu.sistemas.sisgiste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.core.net.SyslogOutputStream;
import pe.edu.sistemas.sisgiste.model.IncidenciaReporteModel;
import pe.edu.sistemas.sisgiste.service.IncidenciaService;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	IncidenciaService incidenciaService;
	@PostMapping("/mostrarIncidencias")
	
	public @ResponseBody String mostrarIncidencias(@RequestParam("problema") String problema,
			@RequestParam("idLugarIncidencia") String idLugarIncidencia,@RequestParam("idEquipo") String idEquipo) {
		//System.out.println("Problema: "+problema+". idLugarIncidencia: "+idLugarIncidencia+". idEquipo: "+idEquipo);
		
		List<IncidenciaReporteModel> incidencias = incidenciaService
				.obtenerIncidenciasPorProblemaYLugarIncidenciaYEquipo(problema, idLugarIncidencia,idEquipo);
		StringBuilder html = new StringBuilder();
		html.append("<table class=\"table\">");
		html.append("<thead class=\"thead-dark\">");
		html.append("<tr>");
		html.append("<th>Fecha</th>");
		html.append("<th>Lugar Incidencia</th>");
		html.append("<th>Problema</th>");
		html.append("<th>Solucion</th>");
		html.append("</tr>");
		html.append("</thead>");
		if (!incidencias.isEmpty()) {
			for (IncidenciaReporteModel I : incidencias) {
				html.append("<tr class=\"bg-white\">");

				html.append("<td>" + I.getFecha() + "</td>");
				html.append("<td>" + I.getLugarIncidencia() + "</td>");
				html.append("<td>" + I.getProblema() + "</td>");
				html.append("<td>" + I.getSolucion() + "</td>");

				html.append("</tr>");
			}
			html.append("</table>");
		} else {
			html.append("<tr class=\"bg-danger text-light\">");

			html.append("<td> NO </td>");
			html.append("<td> HAY </td>");
			html.append("<td> NINGÚN</td>");
			html.append("<td> RESULTADO </td>");

			html.append("</tr>");
		}
		//System.out.println(html.toString());

		return html.toString();
	}
}
