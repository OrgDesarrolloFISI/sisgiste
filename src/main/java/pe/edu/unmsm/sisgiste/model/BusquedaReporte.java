package pe.edu.unmsm.sisgiste.model;

public class BusquedaReporte {

	String idTecnico;
	String nombreTecnico;
	String fechaInicioBusqueda;
	String fechaFinBusqueda;
	
	public String getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(String idTecnico) {
		this.idTecnico = idTecnico;
	}
	public String getNombreTecnico() {
		return nombreTecnico;
	}
	public void setNombreTecnico(String nombreTecnico) {
		this.nombreTecnico = nombreTecnico;
	}
	public String getFechaInicioBusqueda() {
		return fechaInicioBusqueda;
	}
	public void setFechaInicioBusqueda(String fechaInicioBusqueda) {
		this.fechaInicioBusqueda = fechaInicioBusqueda;
	}
	public String getFechaFinBusqueda() {
		return fechaFinBusqueda;
	}
	public void setFechaFinBusqueda(String fechaFinBusqueda) {
		this.fechaFinBusqueda = fechaFinBusqueda;
	}
	@Override
	public String toString() {
		return "BusquedaReporte [idTecnico=" + idTecnico + ", nombreTecnico=" + nombreTecnico + ", fechaInicioBusqueda="
				+ fechaInicioBusqueda + ", fechaFinBusqueda=" + fechaFinBusqueda + "]";
	}	
}
