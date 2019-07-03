package proyecto_gimnasioutnWeb.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import proyecto_gimnasioutn.model.entities.Rol;
import proyecto_gimnasioutn.model.manager.ManagerRol;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanRol implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerRol managerRol;
	private List<Rol> listaRol;
	private Rol rol;
	private boolean panelColapsado;
	private Rol rolSeleccionado;
	
	public BeanRol() {
		
	}
	@PostConstruct
	public void inicializar() {
		listaRol=managerRol.findAllRol();
		rol=new Rol();
		panelColapsado=true;
	}
	public void actionListenerColapsadoPanel() {
		panelColapsado=!panelColapsado;
	}
	
	public void actionListenerInsertarRol() {
		try {
			managerRol.insertarRol(rol);
			listaRol=managerRol.findAllRol();
			rol=new Rol();
			JSFUtil.createMensajeInfo("Rol ingresado correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarRol(int id) {
		managerRol.eliminarRol(id);
		listaRol=managerRol.findAllRol();
		JSFUtil.createMensajeInfo("Rol eliminado correctamente");
	}
	public void actionListenerSelecionarRol(Rol rol) {
		rolSeleccionado=rol;
	}
	public void actionListenerActualizarRol() {
		try {
			managerRol.actualizarRol(rolSeleccionado);
			listaRol=managerRol.findAllRol();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public ManagerRol getManagerRol() {
		return managerRol;
	}
	public void setManagerRol(ManagerRol managerRol) {
		this.managerRol = managerRol;
	}
	public List<Rol> getListaRol() {
		return listaRol;
	}
	public void setListaRol(List<Rol> listaRol) {
		this.listaRol = listaRol;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	public Rol getRolSeleccionado() {
		return rolSeleccionado;
	}
	public void setRolSeleccionado(Rol rolSeleccionado) {
		this.rolSeleccionado = rolSeleccionado;
	}
	

}
