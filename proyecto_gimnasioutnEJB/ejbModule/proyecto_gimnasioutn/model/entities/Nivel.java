package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@Table(name="nivel")
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ni_id", unique=true, nullable=false)
	private Integer niId;

	@Column(name="ni_descripcion", length=2147483647)
	private String niDescripcion;

	public Nivel() {
	}

	public Integer getNiId() {
		return this.niId;
	}

	public void setNiId(Integer niId) {
		this.niId = niId;
	}

	public String getNiDescripcion() {
		return this.niDescripcion;
	}

	public void setNiDescripcion(String niDescripcion) {
		this.niDescripcion = niDescripcion;
	}

}