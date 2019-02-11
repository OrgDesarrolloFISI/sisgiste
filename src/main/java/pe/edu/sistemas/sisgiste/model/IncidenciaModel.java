package pe.edu.sistemas.sisgiste.model;

import java.util.Date;

public class IncidenciaModel {
	int idIncidencia;
	int idTecnicoRecepcionista;
	String usuario;
	int idLugarIncidencia;
	int idEquipo;
	String SBN;
	String problema;
	int idTecnicoSolucionador;
	String descripcionSolucion;
	Date fechaIncidencia;
	Date horaInicio;
	Date horaFin;
	String estado;
	String nombreTecnicoRecepcionista;
	String nombreOficina;
	
	public int getIdIncidencia() {
		return idIncidencia;
	}
	public void setIdIncidencia(int idIncidencia) {
		this.idIncidencia = idIncidencia;
	}
	public int getIdTecnicoRecepcionista() {
		return idTecnicoRecepcionista;
	}
	public void setIdTecnicoRecepcionista(int idTecnicoRecepcionista) {
		this.idTecnicoRecepcionista = idTecnicoRecepcionista;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getIdLugarIncidencia() {
		return idLugarIncidencia;
	}
	public void setIdLugarIncidencia(int idLugarIncidencia) {
		this.idLugarIncidencia = idLugarIncidencia;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getSBN() {
		return SBN;
	}
	public void setSBN(String sBN) {
		SBN = sBN;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public int getIdTecnicoSolucionador() {
		return idTecnicoSolucionador;
	}
	public void setIdTecnicoSolucionador(int idTecnicoSolucionador) {
		this.idTecnicoSolucionador = idTecnicoSolucionador;
	}
	public String getDescripcionSolucion() {
		return descripcionSolucion;
	}
	public void setDescripcionSolucion(String descripcionSolucion) {
		this.descripcionSolucion = descripcionSolucion;
	}
	public Date getFechaIncidencia() {
		return fechaIncidencia;
	}
	public void setFechaIncidencia(Date fechaIncidencia) {
		this.fechaIncidencia = fechaIncidencia;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombreTecnicoRecepcionista() {
		return nombreTecnicoRecepcionista;
	}
	public void setNombreTecnicoRecepcionista(String nombreTecnicoRecepcionista) {
		this.nombreTecnicoRecepcionista = nombreTecnicoRecepcionista;
	}
	public String getNombreOficina() {
		return nombreOficina;
	}
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}
	@Override
	public String toString() {
		return "IncidenciaModel [idIncidencia=" + idIncidencia + ", idTecnicoRecepcionista=" + idTecnicoRecepcionista
				+ ", usuario=" + usuario + ", idLugarIncidencia=" + idLugarIncidencia + ", idEquipo=" + idEquipo
				+ ", SBN=" + SBN + ", problema=" + problema + ", idTecnicoSolucionador=" + idTecnicoSolucionador
				+ ", descripcionSolucion=" + descripcionSolucion + ", fechaIncidencia=" + fechaIncidencia
				+ ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", estado=" + estado
				+ ", nombreTecnicoRecepcionista=" + nombreTecnicoRecepcionista + ", nombreOficina=" + nombreOficina
				+ "]";
	}
	
	
	
}
