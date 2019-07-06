package proyecto_gimnasioutnWeb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import proyecto_gimnasioutn.model.entities.Peticione;
import proyecto_gimnasioutn.model.manager.ManagerPeticiones;
@Named
@SessionScoped
public class BeanPeticiones  implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerPeticiones managerPeticiones;
	private List<Peticione> listaPeticiones;
	private Peticione peticion;
	private boolean panelColapsado;
	private Peticione peticionSeleccionada;
	
	@PostConstruct
	public void inicializar() {
		listaPeticiones = managerPeticiones.findAllPeticiones();
		peticion=new Peticione();
		panelColapsado=true;
	}
	
	public void  actionListenerColapsarPanel() {
		panelColapsado=!panelColapsado;
	}
	
	public void actionListenerInsertarPeticion() {
		try {
			managerPeticiones.insertarPeticiones(peticion);
			listaPeticiones=managerPeticiones.findAllPeticiones();
			peticion=new Peticione();
			JSFUtil.createMensajeInfo("Datos de Peticion Ingresados");
		}catch(Exception e){
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
			
	}
	
	public void actionListenerElminarPeticion(int ptc_id) {
		managerPeticiones.eliminarPeticione(ptc_id);
		listaPeticiones=managerPeticiones.findAllPeticiones();
		JSFUtil.createMensajeInfo("Peticion Eliminado");
	}
	
	public void actionListenerSelecionarPeticion(Peticione peticion) {
		peticionSeleccionada=peticion;
	}
	
	public void actionListenerActualizarPeticion() {
		try {
			managerPeticiones.actualizarPeticiones(peticionSeleccionada);
			listaPeticiones=managerPeticiones.findAllPeticiones();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public List<Peticione> getListaPeticiones() {
		return listaPeticiones;
	}
	public void setListaPeticiones(List<Peticione> listaPeticiones) {
		this.listaPeticiones = listaPeticiones;
	}
	public Peticione getPeticion() {
		return peticion;
	}
	public void setPeticion(Peticione peticion) {
		this.peticion = peticion;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	public Peticione getPeticionSeleccionada() {
		return peticionSeleccionada;
	}
	public void setPeticionSeleccionada(Peticione peticionSeleccionada) {
		this.peticionSeleccionada = peticionSeleccionada;
	}
	
	
	

}
