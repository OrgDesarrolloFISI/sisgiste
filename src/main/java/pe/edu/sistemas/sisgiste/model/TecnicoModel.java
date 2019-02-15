package pe.edu.sistemas.sisgiste.model;

public class TecnicoModel implements Comparable<TecnicoModel>{

	int idTecnico;
	String nombreCompleto;
	int incidenciasAtendidas;
	
	public int getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public int getIncidenciasAtendidas() {
		return incidenciasAtendidas;
	}
	public void setIncidenciasAtendidas(int incidenciasAtendidas) {
		this.incidenciasAtendidas = incidenciasAtendidas;
	}
	@Override
	public String toString() {
		return "TecnicoModel [idTecnico=" + idTecnico + ", nombreCompleto=" + nombreCompleto + ", incidenciasAtendidas="
				+ incidenciasAtendidas + "]";
	}
	@Override
	public int compareTo(TecnicoModel TM) {
		int incidenciaAComparar= TM.getIncidenciasAtendidas();
		return incidenciaAComparar-this.incidenciasAtendidas;
	}
	
}
