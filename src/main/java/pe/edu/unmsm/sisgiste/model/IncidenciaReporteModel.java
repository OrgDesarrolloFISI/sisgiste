package pe.edu.unmsm.sisgiste.model;

public class IncidenciaReporteModel {

	String fecha;
	String lugarIncidencia;
	String problema;
	String solucion;
	
	
	public IncidenciaReporteModel() {
	}
	
	
	public IncidenciaReporteModel(String fecha, String lugarIncidencia, String problema, String solucion) {
		this.fecha = fecha;
		this.lugarIncidencia = lugarIncidencia;
		this.problema = problema;
		this.solucion = solucion;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getLugarIncidencia() {
		return lugarIncidencia;
	}
	public void setLugarIncidencia(String lugarIncidencia) {
		this.lugarIncidencia = lugarIncidencia;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public String getSolucion() {
		return solucion;
	}
	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}
	@Override
	public String toString() {
		return "IncidenciaReporteModel [fecha=" + fecha + ", lugarIncidencia=" + lugarIncidencia + ", problema="
				+ problema + ", solucion=" + solucion + "]";
	}
	
	
}
