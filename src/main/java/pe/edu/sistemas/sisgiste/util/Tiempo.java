package pe.edu.sistemas.sisgiste.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Tiempo {

	
	public Date obtenerFechaYHoraActual(){
		Date fechaActual= new Date();
		return fechaActual;
	}
	
	public Date obtenerFechaDeString(String fechaString){
		Calendar cal=Calendar.getInstance();

		String [] fechaPartes= fechaString.split("/");		//Formato: dd/mm/yyyy
		int dia = Integer.parseInt(fechaPartes[0]);
		int mes = Integer.parseInt(fechaPartes[1])-1;
		int anio = Integer.parseInt(fechaPartes[2]);
		
		cal.set(anio,mes,dia);
		Date fecha=cal.getTime();
		
		return fecha;
		
	}
	
	public String obtenerFechaActual(){
		Date fechaActual= new Date();
		Calendar cal= Calendar.getInstance();
		cal.setTime(fechaActual);
		
		String salida=convertirADosCifras(cal.get(Calendar.DAY_OF_MONTH))+"/"+convertirADosCifras(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
		return salida;
	}
	
	public String convertirADosCifras(int fecha){
		String mesString="";
		if(fecha>=0 && fecha<=9)
			mesString+="0";
		mesString+=fecha;
		return mesString;
	}
}
