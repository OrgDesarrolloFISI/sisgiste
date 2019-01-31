package pe.edu.unmsm.sisgiste.model;

public class LugarIncidenciaModel {

	int idLugarIncidencia;
	String nombreLugarIncidencia;
	
	public int getIdLugarIncidencia() {
		return idLugarIncidencia;
	}
	public void setIdLugarIncidencia(int idLugarIncidencia) {
		this.idLugarIncidencia = idLugarIncidencia;
	}
	public String getNombreLugarIncidencia() {
		return nombreLugarIncidencia;
	}
	public void setNombreLugarIncidencia(String nombreLugarIncidencia) {
		this.nombreLugarIncidencia = nombreLugarIncidencia;
	}
	@Override
	public String toString() {
		return "LugarIncidenciaModel [idLugarIncidencia=" + idLugarIncidencia + ", nombreLugarIncidencia="
				+ nombreLugarIncidencia + "]";
	}
	
	
}
