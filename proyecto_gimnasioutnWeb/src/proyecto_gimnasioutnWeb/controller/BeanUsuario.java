package proyecto_gimnasioutnWeb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//import proyecto_gimnasioutn.controller.JSFUtil;
import proyecto_gimnasioutn.model.entities.Usuario;
import proyecto_gimnasioutn.model.manager.ManagerUsuario;

@Named
@SessionScoped
public class BeanUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerUsuario managerUsuario;
	private List<Usuario> listaUsuarios;
	private Usuario usuario;
	private boolean panelColapsado;
	private Usuario usuarioSeleccionado;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	@PostConstruct
	public void inicializar() {
		listaUsuarios=managerUsuario.findAllUsuarios();
		usuario = new Usuario();
		panelColapsado=true;
	}
	
	public void  actionListenerColapsarPanel() {
		panelColapsado=!panelColapsado;
	}
	
	public void actionListenerInsertarUsuario() {
		try {
			managerUsuario.insertarUsuario(usuario);
			listaUsuarios=managerUsuario.findAllUsuarios();
			usuario=new Usuario();
			JSFUtil.createMensajeInfo("Datos de Usuario Ingresados");
		}catch(Exception e){
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
			
	}
	
	public void actionListenerElminarUsuario(int id_usuario) {
		managerUsuario.eliminarUsuario(id_usuario);
		listaUsuarios=managerUsuario.findAllUsuarios();
		JSFUtil.createMensajeInfo("Usuario Eliminado");
	}
	
	public void actionListenerSelecionarUsuario(Usuario usuario) {
		usuarioSeleccionado=usuario;
	}
	
	public void actionListenerActualizarUsuario() {
		try {
			managerUsuario.actualizarUsuario(usuarioSeleccionado);
			listaUsuarios=managerUsuario.findAllUsuarios();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isPanelColapsado() {
		return panelColapsado;
	}

	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}


	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	
}
