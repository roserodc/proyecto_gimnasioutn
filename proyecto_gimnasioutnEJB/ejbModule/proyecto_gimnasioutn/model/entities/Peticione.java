package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the peticiones database table.
 * 
 */
@Entity
@Table(name="peticiones")
@NamedQuery(name="Peticione.findAll", query="SELECT p FROM Peticione p")
public class Peticione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ptc_id", unique=true, nullable=false)
	private Integer ptcId;

	@Column(name="est_id_estados")
	private Integer estIdEstados;

	@Column(name="ge_id_guia_entrenamiento")
	private Integer geIdGuiaEntrenamiento;

	@Temporal(TemporalType.DATE)
	@Column(name="ptc_fecha")
	private Date ptcFecha;

	@Column(name="ptc_hora_fin")
	private Time ptcHoraFin;

	@Column(name="ptc_hora_inicio")
	private Time ptcHoraInicio;

	@Column(name="tp_id_tipo_peticion")
	private Integer tpIdTipoPeticion;

	@Column(name="user_id_usuario")
	private Integer userIdUsuario;

	public Peticione() {
	}

	public Integer getPtcId() {
		return this.ptcId;
	}

	public void setPtcId(Integer ptcId) {
		this.ptcId = ptcId;
	}

	public Integer getEstIdEstados() {
		return this.estIdEstados;
	}

	public void setEstIdEstados(Integer estIdEstados) {
		this.estIdEstados = estIdEstados;
	}

	public Integer getGeIdGuiaEntrenamiento() {
		return this.geIdGuiaEntrenamiento;
	}

	public void setGeIdGuiaEntrenamiento(Integer geIdGuiaEntrenamiento) {
		this.geIdGuiaEntrenamiento = geIdGuiaEntrenamiento;
	}

	public Date getPtcFecha() {
		return this.ptcFecha;
	}

	public void setPtcFecha(Date ptcFecha) {
		this.ptcFecha = ptcFecha;
	}

	public Time getPtcHoraFin() {
		return this.ptcHoraFin;
	}

	public void setPtcHoraFin(Time ptcHoraFin) {
		this.ptcHoraFin = ptcHoraFin;
	}

	public Time getPtcHoraInicio() {
		return this.ptcHoraInicio;
	}

	public void setPtcHoraInicio(Time ptcHoraInicio) {
		this.ptcHoraInicio = ptcHoraInicio;
	}

	public Integer getTpIdTipoPeticion() {
		return this.tpIdTipoPeticion;
	}

	public void setTpIdTipoPeticion(Integer tpIdTipoPeticion) {
		this.tpIdTipoPeticion = tpIdTipoPeticion;
	}

	public Integer getUserIdUsuario() {
		return this.userIdUsuario;
	}

	public void setUserIdUsuario(Integer userIdUsuario) {
		this.userIdUsuario = userIdUsuario;
	}

}