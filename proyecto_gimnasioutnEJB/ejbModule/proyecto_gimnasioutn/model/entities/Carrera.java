package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity
@NamedQuery(name="Carrera.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ca_id")
	private Integer caId;

	@Column(name="ca_acronimo")
	private String caAcronimo;

	@Column(name="ca_descripcion")
	private String caDescripcion;

	@Column(name="f_id_facultad")
	private Integer fIdFacultad;

	public Carrera() {
	}

	public Integer getCaId() {
		return this.caId;
	}

	public void setCaId(Integer caId) {
		this.caId = caId;
	}

	public String getCaAcronimo() {
		return this.caAcronimo;
	}

	public void setCaAcronimo(String caAcronimo) {
		this.caAcronimo = caAcronimo;
	}

	public String getCaDescripcion() {
		return this.caDescripcion;
	}

	public void setCaDescripcion(String caDescripcion) {
		this.caDescripcion = caDescripcion;
	}

	public Integer getFIdFacultad() {
		return this.fIdFacultad;
	}

	public void setFIdFacultad(Integer fIdFacultad) {
		this.fIdFacultad = fIdFacultad;
	}

}