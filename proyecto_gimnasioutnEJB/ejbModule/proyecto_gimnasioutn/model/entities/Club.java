package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the club database table.
 * 
 */
@Entity
@NamedQuery(name="Club.findAll", query="SELECT c FROM Club c")
public class Club implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clu_id")
	private Integer cluId;

	@Column(name="clu_descripcion")
	private String cluDescripcion;

	public Club() {
	}

	public Integer getCluId() {
		return this.cluId;
	}

	public void setCluId(Integer cluId) {
		this.cluId = cluId;
	}

	public String getCluDescripcion() {
		return this.cluDescripcion;
	}

	public void setCluDescripcion(String cluDescripcion) {
		this.cluDescripcion = cluDescripcion;
	}

}