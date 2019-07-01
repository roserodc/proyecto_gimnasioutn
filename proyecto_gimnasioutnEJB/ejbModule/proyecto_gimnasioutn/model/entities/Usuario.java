package proyecto_gimnasioutn.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private Integer userId;

	@Column(name="ca_id_carrera")
	private Integer caIdCarrera;

	@Column(name="clu_id_club")
	private Integer cluIdClub;

	@Column(name="ni_id_nivel")
	private Integer niIdNivel;

	@Column(name="r_id_roles")
	private Integer rIdRoles;

	@Column(name="user_apellido")
	private String userApellido;

	@Column(name="user_ci")
	private String userCi;

	@Column(name="user_nombre")
	private String userNombre;

	@Column(name="user_pass")
	private String userPass;

	@Column(name="user_telefono")
	private String userTelefono;

	public Usuario() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCaIdCarrera() {
		return this.caIdCarrera;
	}

	public void setCaIdCarrera(Integer caIdCarrera) {
		this.caIdCarrera = caIdCarrera;
	}

	public Integer getCluIdClub() {
		return this.cluIdClub;
	}

	public void setCluIdClub(Integer cluIdClub) {
		this.cluIdClub = cluIdClub;
	}

	public Integer getNiIdNivel() {
		return this.niIdNivel;
	}

	public void setNiIdNivel(Integer niIdNivel) {
		this.niIdNivel = niIdNivel;
	}

	public Integer getRIdRoles() {
		return this.rIdRoles;
	}

	public void setRIdRoles(Integer rIdRoles) {
		this.rIdRoles = rIdRoles;
	}

	public String getUserApellido() {
		return this.userApellido;
	}

	public void setUserApellido(String userApellido) {
		this.userApellido = userApellido;
	}

	public String getUserCi() {
		return this.userCi;
	}

	public void setUserCi(String userCi) {
		this.userCi = userCi;
	}

	public String getUserNombre() {
		return this.userNombre;
	}

	public void setUserNombre(String userNombre) {
		this.userNombre = userNombre;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserTelefono() {
		return this.userTelefono;
	}

	public void setUserTelefono(String userTelefono) {
		this.userTelefono = userTelefono;
	}

}