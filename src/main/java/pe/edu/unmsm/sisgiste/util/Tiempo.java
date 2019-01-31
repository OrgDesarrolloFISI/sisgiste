package pe.edu.unmsm.sisgiste.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Tiempo {

	
	public Date obtenerFechaYHoraActual(){
		Date fechaActual= new Date();
		return fechaActual;
	}
	
	
	public String obtenerFechaActual(){
		Date fechaActual= new Date();
		Calendar cal= Calendar.getInstance();
		cal.setTime(fechaActual);
		
		String salida=cal.get(Calendar.DAY_OF_MONTH)+"/"+convertirMesADosCifras(cal.get(Calendar.MONTH))+"/"+cal.get(Calendar.YEAR);
		return salida;
	}
	
	public String convertirMesADosCifras(int mes){
		mes++;
		String mesString="";
		if(mes>=0 && mes<=9)
			mesString+="0";
		mesString+=mes;
		return mesString;
		
	}
}
