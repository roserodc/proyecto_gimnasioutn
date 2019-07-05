package proyecto_gimnasioutnWeb.controller;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class BeanLogin implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String cedUsuario;
	private String clave;
	
	public void accederSistema(String cedUsuario, String clave) {
		try {
			return;
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMensajeError(e.getMessage());
		}
	}
	
	public String getCedUsuario() {
		return cedUsuario;
	}
	public void setCedUsuario(String cedUsuario) {
		this.cedUsuario = cedUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

}
