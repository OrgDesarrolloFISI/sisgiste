package pe.edu.sistemas.sisgiste.entity;
// Generated 03-feb-2019 18:44:56 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoLugarIncidencia generated by hbm2java
 */
@Entity
@Table(name = "TIPO_LUGAR_INCIDENCIA", catalog = "modeloGeneralFisi")
public class TipoLugarIncidencia implements java.io.Serializable {

	private Integer idTipoLugarIncidencia;
	private String tipoLugarIncidenciaNombre;
	private Set<LugarIncidencia> lugarIncidencias = new HashSet<LugarIncidencia>(0);

	public TipoLugarIncidencia() {
	}

	public TipoLugarIncidencia(String tipoLugarIncidenciaNombre) {
		this.tipoLugarIncidenciaNombre = tipoLugarIncidenciaNombre;
	}

	public TipoLugarIncidencia(String tipoLugarIncidenciaNombre, Set<LugarIncidencia> lugarIncidencias) {
		this.tipoLugarIncidenciaNombre = tipoLugarIncidenciaNombre;
		this.lugarIncidencias = lugarIncidencias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_TIPO_LUGAR_INCIDENCIA", unique = true, nullable = false)
	public Integer getIdTipoLugarIncidencia() {
		return this.idTipoLugarIncidencia;
	}

	public void setIdTipoLugarIncidencia(Integer idTipoLugarIncidencia) {
		this.idTipoLugarIncidencia = idTipoLugarIncidencia;
	}

	@Column(name = "TIPO_LUGAR_INCIDENCIA_NOMBRE", nullable = false, length = 20)
	public String getTipoLugarIncidenciaNombre() {
		return this.tipoLugarIncidenciaNombre;
	}

	public void setTipoLugarIncidenciaNombre(String tipoLugarIncidenciaNombre) {
		this.tipoLugarIncidenciaNombre = tipoLugarIncidenciaNombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLugarIncidencia")
	public Set<LugarIncidencia> getLugarIncidencias() {
		return this.lugarIncidencias;
	}

	public void setLugarIncidencias(Set<LugarIncidencia> lugarIncidencias) {
		this.lugarIncidencias = lugarIncidencias;
	}

}
