package proyecto_gimnasioutnWeb.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import proyecto_gimnasioutn.model.entities.Nivel;
import proyecto_gimnasioutn.model.manager.ManagerNivel;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanNivel implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerNivel managerNivel;
	private List<Nivel> listaniveles;
	private Nivel nivel;
	private boolean panelColapsado;
	private Nivel nivelseleccionado;
	
	public BeanNivel() {
		
	}
	@PostConstruct
	public void inicializar() {
		listaniveles=managerNivel.findAllNivel();
		nivel=new Nivel();
	}
	public void actionListenerColapsadoPanel() {
		panelColapsado=!panelColapsado;
	}
	
	public void actionListenerInsertaarNivel() {
		try {
			managerNivel.insertarNivel(nivel);
			listaniveles=managerNivel.findAllNivel();
			nivel=new Nivel();
			JSFUtil.createMensajeInfo("Nivel ingresado correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarNivel(int id) {
		managerNivel.eliminarNivel(id);
		listaniveles=managerNivel.findAllNivel();
		JSFUtil.createMensajeInfo("Nivel eliminado correctamente");
	}
	public void actionListenerSeleccionarNivel(Nivel nivel) {
		nivelseleccionado=nivel;
	}
	public void actionListenerActualizarNivel() {
		try {
			managerNivel.actualizarNivel(nivelseleccionado);
			listaniveles=managerNivel.findAllNivel();
			JSFUtil.createMensajeInfo("Datos Actualizados Correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
		
	public List<Nivel> getListaniveles() {
		return listaniveles;
	}
	public void setListaniveles(List<Nivel> listaniveles) {
		this.listaniveles = listaniveles;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public Nivel getNivelseleccionado() {
		return nivelseleccionado;
	}
	public void setNivelseleccionado(Nivel nivelseleccionado) {
		this.nivelseleccionado = nivelseleccionado;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	
}
