package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the planes database table.
 * 
 */
@Entity
@Table(name="planes")
@NamedQuery(name="Plan.findAll", query="SELECT p FROM Plan p")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pl_id")
	private Integer plId;

	@Column(name="ge_id_guia_entrenamiento")
	private Integer geIdGuiaEntrenamiento;

	@Column(name="pl_tipo")
	private String plTipo;

	public Plan() {
	}

	public Integer getPlId() {
		return this.plId;
	}

	public void setPlId(Integer plId) {
		this.plId = plId;
	}

	public Integer getGeIdGuiaEntrenamiento() {
		return this.geIdGuiaEntrenamiento;
	}

	public void setGeIdGuiaEntrenamiento(Integer geIdGuiaEntrenamiento) {
		this.geIdGuiaEntrenamiento = geIdGuiaEntrenamiento;
	}

	public String getPlTipo() {
		return this.plTipo;
	}

	public void setPlTipo(String plTipo) {
		this.plTipo = plTipo;
	}

}