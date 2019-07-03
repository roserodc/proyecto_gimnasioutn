package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_peticion database table.
 * 
 */
@Entity
@Table(name="tipo_peticion")
@NamedQuery(name="TipoPeticion.findAll", query="SELECT t FROM TipoPeticion t")
public class TipoPeticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tp_id", unique=true, nullable=false)
	private Integer tpId;

	@Column(name="tp_descripcion", length=2147483647)
	private String tpDescripcion;

	public TipoPeticion() {
	}

	public Integer getTpId() {
		return this.tpId;
	}

	public void setTpId(Integer tpId) {
		this.tpId = tpId;
	}

	public String getTpDescripcion() {
		return this.tpDescripcion;
	}

	public void setTpDescripcion(String tpDescripcion) {
		this.tpDescripcion = tpDescripcion;
	}

}