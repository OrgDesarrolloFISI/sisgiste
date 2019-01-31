package pe.edu.unmsm.sisgiste.model;

public class TipoEquipoModel {

	int idTipoEquipo;
	String nombreTipoEquipo;
	public int getIdTipoEquipo() {
		return idTipoEquipo;
	}
	public void setIdTipoEquipo(int idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
	}
	public String getNombreTipoEquipo() {
		return nombreTipoEquipo;
	}
	public void setNombreTipoEquipo(String nombreTipoEquipo) {
		this.nombreTipoEquipo = nombreTipoEquipo;
	}
	@Override
	public String toString() {
		return "TipoEquipoModel [idTipoEquipo=" + idTipoEquipo + ", nombreTipoEquipo=" + nombreTipoEquipo + "]";
	}
	
}
