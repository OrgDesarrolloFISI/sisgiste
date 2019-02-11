package pe.edu.sistemas.sisgiste.model;

public class TecnicoModel {

	int idTecnico;
	String nombreCompleto;
	
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
	@Override
	public String toString() {
		return "TecnicoModel [id=" + idTecnico + ", nombreCompleto=" + nombreCompleto + "]";
	}
	
	
}
