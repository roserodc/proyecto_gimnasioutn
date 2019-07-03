package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="r_id", unique=true, nullable=false)
	private Integer rId;

	@Column(name="r_descripcion", length=2147483647)
	private String rDescripcion;

	public Rol() {
	}

	public Integer getRId() {
		return this.rId;
	}

	public void setRId(Integer rId) {
		this.rId = rId;
	}

	public String getRDescripcion() {
		return this.rDescripcion;
	}

	public void setRDescripcion(String rDescripcion) {
		this.rDescripcion = rDescripcion;
	}

}