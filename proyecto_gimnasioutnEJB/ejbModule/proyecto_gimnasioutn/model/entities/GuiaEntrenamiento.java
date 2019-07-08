package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the guia_entrenamiento database table.
 * 
 */
@Entity
@Table(name="guia_entrenamiento")
@NamedQuery(name="GuiaEntrenamiento.findAll", query="SELECT g FROM GuiaEntrenamiento g")
public class GuiaEntrenamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ge_id")
	private Integer geId;

	@Column(name="ge_descripcion")
	private String geDescripcion;

	public GuiaEntrenamiento() {
	}

	public Integer getGeId() {
		return this.geId;
	}

	public void setGeId(Integer geId) {
		this.geId = geId;
	}

	public String getGeDescripcion() {
		return this.geDescripcion;
	}

	public void setGeDescripcion(String geDescripcion) {
		this.geDescripcion = geDescripcion;
	}

}