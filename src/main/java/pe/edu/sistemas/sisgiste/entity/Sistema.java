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
 * Sistema generated by hbm2java
 */
@Entity
@Table(name = "SISTEMA", catalog = "modeloGeneralFisi")
public class Sistema implements java.io.Serializable {

	private Integer idSistema;
	private String sistemaNombre;
	private String sistemaDescripcion;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Sistema() {
	}

	public Sistema(String sistemaNombre) {
		this.sistemaNombre = sistemaNombre;
	}

	public Sistema(String sistemaNombre, String sistemaDescripcion, Set<Usuario> usuarios) {
		this.sistemaNombre = sistemaNombre;
		this.sistemaDescripcion = sistemaDescripcion;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_SISTEMA", unique = true, nullable = false)
	public Integer getIdSistema() {
		return this.idSistema;
	}

	public void setIdSistema(Integer idSistema) {
		this.idSistema = idSistema;
	}

	@Column(name = "SISTEMA_NOMBRE", nullable = false, length = 45)
	public String getSistemaNombre() {
		return this.sistemaNombre;
	}

	public void setSistemaNombre(String sistemaNombre) {
		this.sistemaNombre = sistemaNombre;
	}

	@Column(name = "SISTEMA_DESCRIPCION", length = 100)
	public String getSistemaDescripcion() {
		return this.sistemaDescripcion;
	}

	public void setSistemaDescripcion(String sistemaDescripcion) {
		this.sistemaDescripcion = sistemaDescripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sistema")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}