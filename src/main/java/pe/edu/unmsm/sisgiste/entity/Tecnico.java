package pe.edu.unmsm.sisgiste.entity;
// Generated 29/01/2019 03:15:07 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tecnico generated by hbm2java
 */
@Entity
@Table(name = "tecnico", catalog = "modelogeneralfisi")
public class Tecnico implements java.io.Serializable {

	private Integer idTecnico;
	private Persona persona;
	private String tecnicoActivo;
	private Set<Incidencia> incidenciasForTecnicoIdTecnicoRecepcionista = new HashSet<Incidencia>(0);
	private Set<Incidencia> incidenciasForTecnicoIdTecnicoSolucionador = new HashSet<Incidencia>(0);

	public Tecnico() {
	}

	public Tecnico(Persona persona, String tecnicoActivo) {
		this.persona = persona;
		this.tecnicoActivo = tecnicoActivo;
	}

	public Tecnico(Persona persona, String tecnicoActivo, Set<Incidencia> incidenciasForTecnicoIdTecnicoRecepcionista,
			Set<Incidencia> incidenciasForTecnicoIdTecnicoSolucionador) {
		this.persona = persona;
		this.tecnicoActivo = tecnicoActivo;
		this.incidenciasForTecnicoIdTecnicoRecepcionista = incidenciasForTecnicoIdTecnicoRecepcionista;
		this.incidenciasForTecnicoIdTecnicoSolucionador = incidenciasForTecnicoIdTecnicoSolucionador;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_TECNICO", unique = true, nullable = false)
	public Integer getIdTecnico() {
		return this.idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONA_ID_PERSONA", nullable = false)
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Column(name = "TECNICO_ACTIVO", nullable = false, length = 1)
	public String getTecnicoActivo() {
		return this.tecnicoActivo;
	}

	public void setTecnicoActivo(String tecnicoActivo) {
		this.tecnicoActivo = tecnicoActivo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tecnicoByTecnicoIdTecnicoRecepcionista")
	public Set<Incidencia> getIncidenciasForTecnicoIdTecnicoRecepcionista() {
		return this.incidenciasForTecnicoIdTecnicoRecepcionista;
	}

	public void setIncidenciasForTecnicoIdTecnicoRecepcionista(
			Set<Incidencia> incidenciasForTecnicoIdTecnicoRecepcionista) {
		this.incidenciasForTecnicoIdTecnicoRecepcionista = incidenciasForTecnicoIdTecnicoRecepcionista;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tecnicoByTecnicoIdTecnicoSolucionador")
	public Set<Incidencia> getIncidenciasForTecnicoIdTecnicoSolucionador() {
		return this.incidenciasForTecnicoIdTecnicoSolucionador;
	}

	public void setIncidenciasForTecnicoIdTecnicoSolucionador(
			Set<Incidencia> incidenciasForTecnicoIdTecnicoSolucionador) {
		this.incidenciasForTecnicoIdTecnicoSolucionador = incidenciasForTecnicoIdTecnicoSolucionador;
	}

}