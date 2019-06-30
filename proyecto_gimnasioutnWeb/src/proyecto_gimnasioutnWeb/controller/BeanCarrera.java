package proyecto_gimnasioutnWeb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//import gimnasioutn.controller.JSFUtil;
import proyecto_gimnasioutn.model.entities.Carrera;
import proyecto_gimnasioutn.model.manager.ManagerCarrera;

@Named
@SessionScoped
public class BeanCarrera implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB 
	private ManagerCarrera managerCarrera;
	private List<Carrera> listaCarreras;
	private Carrera carrera;
	private boolean panelColapsado;
	private Carrera carreraSeleccionada;
	
	@PostConstruct
	public void inicializar() {
		listaCarreras=managerCarrera.findAllCarreras();
		carrera = new Carrera();
		panelColapsado= true;
	}
	
	public void  actionListenerColapsarPanel() {
		panelColapsado=!panelColapsado;
	}
	

	public void actionListenerInsertarCarrera() {
		try {
			managerCarrera.insertarCarrera(carrera);
			listaCarreras=managerCarrera.findAllCarreras();
			carrera=new Carrera();
			JSFUtil.createMensajeInfo("Datos de Carrera Ingresados");
		}catch(Exception e){
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
			
	}
	
	public void actionListenerElminarCarrera(int  ca_id) {
		managerCarrera.eliminarCarrera(ca_id);
		listaCarreras=managerCarrera.findAllCarreras();
		JSFUtil.createMensajeInfo("Carrera Eliminada");
	}
	
	public void actionListenerSelecionarCarrera(Carrera carrera) {
		carreraSeleccionada=carrera;
	}
	
	public void actionListenerActualizarCarrera() {
		try {
			managerCarrera.actualizarCarrera(carreraSeleccionada);
			listaCarreras=managerCarrera.findAllCarreras();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Carrera> getListaCarreras() {
		return listaCarreras;
	}

	public void setListaCarreras(List<Carrera> listaCarreras) {
		this.listaCarreras = listaCarreras;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Carrera getCarreraSeleccionada() {
		return carreraSeleccionada;
	}

	public void setCarreraSeleccionada(Carrera carreraSeleccionada) {
		this.carreraSeleccionada = carreraSeleccionada;
	}

	public boolean isPanelColapsado() {
		return panelColapsado;
	}

	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	
}
	