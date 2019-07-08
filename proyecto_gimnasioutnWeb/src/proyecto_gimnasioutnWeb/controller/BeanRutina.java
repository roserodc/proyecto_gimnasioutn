package proyecto_gimnasioutnWeb.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import proyecto_gimnasioutn.model.entities.Rutina;
import proyecto_gimnasioutn.model.manager.ManagerRutina;

@Named
@SessionScoped
public class BeanRutina implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerRutina managerRutina;
	private List<Rutina> listaRutinas;
	private Rutina rutina;
	private boolean panelColapsado;
	private Rutina rutinaSelecionado;

	

	@PostConstruct
	public void inicializar() {
		listaRutinas=managerRutina.findAllRutinas();
		rutina = new Rutina();
		panelColapsado=true;
	}
	
	public void  actionListenerColapsarPanel() {
		panelColapsado=!panelColapsado;
	}
	
	public void actionListenerInsertarRutina() {
		try {
			managerRutina.insertarRutina(rutina);
			listaRutinas = managerRutina.findAllRutinas();
			rutina = new Rutina();
			JSFUtil.createMensajeInfo("Datos de rutina insertados");
		} catch (Exception e) {
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerElminarRutina(int  rtid) {
		managerRutina.eliminarRutina(rtid);
		listaRutinas=managerRutina.findAllRutinas();
		JSFUtil.createMensajeInfo("Rutina Eliminada");
	}
	
	
	public void actionListenerSelecionarRutina(Rutina rutina) {
		rutinaSelecionado=rutina;
	}
	
	public void actionListenerActualizarRutina() {
		try {
			managerRutina.actualizarRutina(rutinaSelecionado);
			listaRutinas=managerRutina.findAllRutinas();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public List<Rutina> getListaRutinas() {
		return listaRutinas;
	}

	public void setListaRutinas(List<Rutina> listaRutinas) {
		this.listaRutinas = listaRutinas;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	public boolean isPanelColapsado() {
		return panelColapsado;
	}

	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}

	public Rutina getRutinaSelecionado() {
		return rutinaSelecionado;
	}

	public void setRutinaSelecionado(Rutina rutinaSelecionado) {
		this.rutinaSelecionado = rutinaSelecionado;
	}


	
	
	
	
}
