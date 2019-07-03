package proyecto_gimnasioutnWeb.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import proyecto_gimnasioutn.model.entities.Estado;
import proyecto_gimnasioutn.model.manager.ManagerEstado;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanEstado implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerEstado managerEstado;
	private List<Estado> listaEstado;
	private Estado estado;
	private boolean panelColapsado;
	private Estado estadoSeleccionado;
	
	public BeanEstado() {
		
	}
	@PostConstruct
	public void inicializar() {
		listaEstado=managerEstado.findAllEstado();
		estado=new Estado();
		panelColapsado=true;
	}
	public void actionListenerColapsadoPanel() {
		panelColapsado=!panelColapsado;
	}
	public void actionListenerInsertarEstado() {
		try {
			managerEstado.insertarEstado(estado);
			listaEstado=managerEstado.findAllEstado();
			estado=new Estado();
			JSFUtil.createMensajeInfo("Estado ingresado correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarEstado(int id) {
		managerEstado.eliminarEstado(id);
		listaEstado=managerEstado.findAllEstado();
		JSFUtil.createMensajeInfo("Estado eliminado correctamente");
	}
	public void actionListenerSeleccionarEstado(Estado estado) {
		estadoSeleccionado=estado;
	}
	
	public void actionListenerActualizarEstado() {
		try {
			managerEstado.actualizarEstado(estadoSeleccionado);
			listaEstado=managerEstado.findAllEstado();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public List<Estado> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<Estado> listaEstado) {
		this.listaEstado = listaEstado;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	public Estado getEstadoSeleccionado() {
		return estadoSeleccionado;
	}
	public void setEstadoSeleccionado(Estado estadoSeleccionado) {
		this.estadoSeleccionado = estadoSeleccionado;
	}
	
	
}
