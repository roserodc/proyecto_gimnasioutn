package proyecto_gimnasioutnWeb.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import proyecto_gimnasioutn.model.entities.TipoPeticion;
import proyecto_gimnasioutn.model.manager.ManagerTipoPeticion;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanTipoPeticion implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerTipoPeticion managerTipoPeticion;
	private List<TipoPeticion> listaTipoPeticion;
	private TipoPeticion tipop;
	private boolean panelColapsado;
	private TipoPeticion tipopSeleccionado;
	
	public BeanTipoPeticion() {
		
	}
	@PostConstruct
	public void inicializar() {
		listaTipoPeticion=managerTipoPeticion.findAllTipoPeticion();
		tipop=new TipoPeticion();
		panelColapsado=true;
	}
	public void actionListenerColapsadoPanel() {
		panelColapsado=!panelColapsado;
	}
	
	public void actionListenerInsertarTipoPeticion() {
		try {
			managerTipoPeticion.insertarTipoPeticion(tipop);
			listaTipoPeticion=managerTipoPeticion.findAllTipoPeticion();
			tipop=new TipoPeticion();
			JSFUtil.createMensajeInfo("Tipo de Petición ingresado correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarTipoPeticion(int id) {
		managerTipoPeticion.eliminarTipoPeticion(id);
		listaTipoPeticion=managerTipoPeticion.findAllTipoPeticion();
		JSFUtil.createMensajeInfo("Tipo de Petición eliminada correctamente");
	}
	public void actionListenerSeleccionarTipoPeticion(TipoPeticion tipop) {
		tipopSeleccionado=tipop;
	}
	public void actionListenerActualizarTipoPeticion() {
		try {
			managerTipoPeticion.actualizarTipoPeticion(tipopSeleccionado);
			listaTipoPeticion=managerTipoPeticion.findAllTipoPeticion();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public List<TipoPeticion> getListaTipoPeticion() {
		return listaTipoPeticion;
	}

	public void setListaTipoPeticion(List<TipoPeticion> listaTipoPeticion) {
		this.listaTipoPeticion = listaTipoPeticion;
	}

	public TipoPeticion getTipop() {
		return tipop;
	}

	public void setTipop(TipoPeticion tipop) {
		this.tipop = tipop;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	public TipoPeticion getTipopSeleccionado() {
		return tipopSeleccionado;
	}
	public void setTipopSeleccionado(TipoPeticion tipopSeleccionado) {
		this.tipopSeleccionado = tipopSeleccionado;
	}

	
}
