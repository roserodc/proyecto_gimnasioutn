package proyecto_gimnasioutnWeb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//import proyecto_gimnasioutn.controller.JSFUtil;
import proyecto_gimnasioutn.model.entities.Club;
import proyecto_gimnasioutn.model.manager.ManagerClub;

@Named
@SessionScoped
public class BeanClub implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerClub managerClub;
	private List<Club> listaClubes;
	private Club club;
	private boolean panelColapsado;
	private Club clubSeleccionado;
	
	@PostConstruct
	public void inicializar() {
		listaClubes=managerClub.findAllClubes();
		club=new Club();
		panelColapsado=true;
	}
	
	public void  actionListenerColapsarPanel() {
		panelColapsado=!panelColapsado;
	}
	
	public void actionListenerInsertarClub() {
		try {
			managerClub.insertarClub(club);
			listaClubes=managerClub.findAllClubes();
			club=new Club();
			JSFUtil.createMensajeInfo("Datos de Club Ingresados");
		}catch(Exception e){
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
			
	}
	
	public void actionListenerElminarClub(int id_club) {
		managerClub.eliminarClub(id_club);
		listaClubes=managerClub.findAllClubes();
		JSFUtil.createMensajeInfo("Club Eliminado");
	}
	
	public void actionListenerSelecionarClub(Club club) {
		clubSeleccionado=club;
	}
	
	public void actionListenerActualizarClub() {
		try {
			managerClub.actualizarClub(clubSeleccionado);
			listaClubes=managerClub.findAllClubes();
			JSFUtil.createMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Club> getListaClubes() {
		return listaClubes;
	}

	public void setListaClubes(List<Club> listaClubes) {
		this.listaClubes = listaClubes;
	}

	public boolean isPanelColapsado() {
		return panelColapsado;
	}

	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}

	public Club getClubSeleccionado() {
		return clubSeleccionado;
	}

	public void setClubSeleccionado(Club clubSeleccionado) {
		this.clubSeleccionado = clubSeleccionado;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}


}
