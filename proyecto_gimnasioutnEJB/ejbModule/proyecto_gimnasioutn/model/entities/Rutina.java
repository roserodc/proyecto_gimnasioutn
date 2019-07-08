package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rutinas database table.
 * 
 */
@Entity
@Table(name="rutinas")
@NamedQuery(name="Rutina.findAll", query="SELECT r FROM Rutina r")
public class Rutina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rt_id")
	private Integer rtId;

	@Column(name="pl_id_planes")
	private Integer plIdPlanes;

	@Column(name="rt_descripcion")
	private String rtDescripcion;

	@Column(name="rt_duracion")
	private Integer rtDuracion;

	@Column(name="rt_repeticiones")
	private Integer rtRepeticiones;

	@Column(name="rt_series")
	private Integer rtSeries;

	public Rutina() {
	}

	public Integer getRtId() {
		return this.rtId;
	}

	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	public Integer getPlIdPlanes() {
		return this.plIdPlanes;
	}

	public void setPlIdPlanes(Integer plIdPlanes) {
		this.plIdPlanes = plIdPlanes;
	}

	public String getRtDescripcion() {
		return this.rtDescripcion;
	}

	public void setRtDescripcion(String rtDescripcion) {
		this.rtDescripcion = rtDescripcion;
	}

	public Integer getRtDuracion() {
		return this.rtDuracion;
	}

	public void setRtDuracion(Integer rtDuracion) {
		this.rtDuracion = rtDuracion;
	}

	public Integer getRtRepeticiones() {
		return this.rtRepeticiones;
	}

	public void setRtRepeticiones(Integer rtRepeticiones) {
		this.rtRepeticiones = rtRepeticiones;
	}

	public Integer getRtSeries() {
		return this.rtSeries;
	}

	public void setRtSeries(Integer rtSeries) {
		this.rtSeries = rtSeries;
	}

}