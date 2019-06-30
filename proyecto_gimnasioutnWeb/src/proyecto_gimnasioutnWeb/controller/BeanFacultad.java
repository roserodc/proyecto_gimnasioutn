package proyecto_gimnasioutnWeb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

//import proyecto_gimnasioutn.controller.JSFUtil;
import proyecto_gimnasioutn.model.entities.Facultad;
import proyecto_gimnasioutn.model.manager.ManagerFacultad;

public class BeanFacultad implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerFacultad managerFacultad;
	private List<Facultad> listaFacultades;
	private Facultad facultad;
	private boolean panelColapsado;
	private Facultad facultadSeleccionada;
	
	@PostConstruct
	public void inicializar() {
		listaFacultades=managerFacultad.findAllFacultades();
		facultad=new Facultad();
		panelColapsado=true;
	}
	
	public void  actionListenerColapsarPanel() {
		panelColapsado=!panelColapsado;
	}
	
	public void actionListenerInsertarFacultad() {
		try {
			managerFacultad.insertarFacultad(facultad);
			listaFacultades=managerFacultad.findAllFacultades();
			facultad=new Facultad();
			JSFUtil.createMensajeInfo("Datos de Facultad Ingresados");
		}catch(Exception e){
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
			
	}
	
	public void actionListenerElminarFacultad(int id_facu) {
		managerFacultad.eliminarFacultad(id_facu);
		listaFacultades=managerFacultad.findAllFacultades();
		JSFUtil.createMensajeInfo("Facultad Eliminada");
	}
	
	public void actionListenerSelecionarFacultad(Facultad facultad) {
		facultadSeleccionada=facultad;
	}
	
	public void actionListenerActualizarFacultad() {
		try {
			managerFacultad.actualizarFacultad(facultadSeleccionada);
			listaFacultades=managerFacultad.findAllFacultades();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Facultad> getListaFacultades() {
		return listaFacultades;
	}

	public void setListaFacultades(List<Facultad> listaFacultades) {
		this.listaFacultades = listaFacultades;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public Facultad getFacultadSeleccionada() {
		return facultadSeleccionada;
	}

	public void setFacultadSeleccionada(Facultad facultadSeleccionada) {
		this.facultadSeleccionada = facultadSeleccionada;
	}

	public boolean isPanelColapsado() {
		return panelColapsado;
	}

	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	
	
	
}
