package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the facultad database table.
 * 
 */
@Entity
@NamedQuery(name="Facultad.findAll", query="SELECT f FROM Facultad f")
public class Facultad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="f_id")
	private Integer fId;

	@Column(name="f_acronimo")
	private String fAcronimo;

	@Column(name="f_descripcion")
	private String fDescripcion;

	public Facultad() {
	}

	public Integer getFId() {
		return this.fId;
	}

	public void setFId(Integer fId) {
		this.fId = fId;
	}

	public String getFAcronimo() {
		return this.fAcronimo;
	}

	public void setFAcronimo(String fAcronimo) {
		this.fAcronimo = fAcronimo;
	}

	public String getFDescripcion() {
		return this.fDescripcion;
	}

	public void setFDescripcion(String fDescripcion) {
		this.fDescripcion = fDescripcion;
	}

}