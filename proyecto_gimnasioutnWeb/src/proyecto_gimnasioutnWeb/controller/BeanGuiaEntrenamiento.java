package proyecto_gimnasioutnWeb.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import proyecto_gimnasioutn.model.entities.GuiaEntrenamiento;
import proyecto_gimnasioutn.model.manager.ManagerGuiaEntrenamiento;
import java.util.List;
import java.io.Serializable;

@Named
@SessionScoped
public class BeanGuiaEntrenamiento implements Serializable {


	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerGuiaEntrenamiento managerGuiaEntrenamiento;
	private List<GuiaEntrenamiento> listaGuiaEntrenamiento;
	private GuiaEntrenamiento guiaEntren;
	private boolean panelColapsado;
	private GuiaEntrenamiento guiaEntrenSeleccionado;
	
	@PostConstruct
	public void inicializar() {
		listaGuiaEntrenamiento = managerGuiaEntrenamiento.findAllGuiaEntrenamiento();
		guiaEntren=new GuiaEntrenamiento();
		panelColapsado=true;
	}
	
	public void actionListenerColapsadoPanel() {
		panelColapsado=!panelColapsado;
	}

	public void actionListenerInsertarGuiaEntrenamiento() {
		try {
			managerGuiaEntrenamiento.insertarGuiaEntrenamiento(guiaEntren);
			listaGuiaEntrenamiento=managerGuiaEntrenamiento.findAllGuiaEntrenamiento();
			guiaEntren=new GuiaEntrenamiento();
			JSFUtil.createMensajeInfo("Guia Entrenamiento ingresado correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarGuiaEntrenamiento(int geId) {
		managerGuiaEntrenamiento.eliminarGuiaEntrenamiento(geId);
		listaGuiaEntrenamiento=managerGuiaEntrenamiento.findAllGuiaEntrenamiento();
		JSFUtil.createMensajeInfo("Guia Entrenamiento eliminado correctamente");
	}
	
	public void actionListenerSelecionarGuiaEntrenamiento(GuiaEntrenamiento guiaEntren) {
		guiaEntrenSeleccionado=guiaEntren;
	}
	
	public void actionListenerActualizarGuiaEntrenamiento() {
		try {
			managerGuiaEntrenamiento.actualizarGuiaEntrenamiento(guiaEntrenSeleccionado);
			listaGuiaEntrenamiento=managerGuiaEntrenamiento.findAllGuiaEntrenamiento();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public ManagerGuiaEntrenamiento getManagerGuiaEntrenamiento() {
		return managerGuiaEntrenamiento;
	}

	public void setManagerGuiaEntrenamiento(ManagerGuiaEntrenamiento managerGuiaEntrenamiento) {
		this.managerGuiaEntrenamiento = managerGuiaEntrenamiento;
	}

	public boolean isPanelColapsado() {
		return panelColapsado;
	}

	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}

	public GuiaEntrenamiento getGuiaEntrenSeleccionado() {
		return guiaEntrenSeleccionado;
	}

	public void setGuiaEntrenSeleccionado(GuiaEntrenamiento guiaEntrenSeleccionado) {
		this.guiaEntrenSeleccionado = guiaEntrenSeleccionado;
	}

	public List<GuiaEntrenamiento> getListaGuiaEntrenamiento() {
		return listaGuiaEntrenamiento;
	}

	public void setListaGuiaEntrenamiento(List<GuiaEntrenamiento> listaGuiaEntrenamiento) {
		this.listaGuiaEntrenamiento = listaGuiaEntrenamiento;
	}

	public GuiaEntrenamiento getGuiaEntren() {
		return guiaEntren;
	}

	public void setGuiaEntren(GuiaEntrenamiento guiaEntren) {
		this.guiaEntren = guiaEntren;
	}
 
	
	
}