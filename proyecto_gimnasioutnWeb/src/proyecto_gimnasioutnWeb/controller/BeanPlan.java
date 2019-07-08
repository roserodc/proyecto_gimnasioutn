package proyecto_gimnasioutnWeb.controller;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import proyecto_gimnasioutn.model.entities.Plan;
import proyecto_gimnasioutn.model.manager.ManagerPlan;


import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanPlan implements Serializable {
		private static final long serialVersionUID = 1L;
		@EJB
		private ManagerPlan managerPlan;
		private List<Plan> listaPlan;
		private Plan plan;
		private boolean panelColapsado;
		private Plan planSeleccionado;
		
		public BeanPlan() {
			
		}
		@PostConstruct
		public void inicializar() {
			listaPlan=managerPlan.findAllPlan();
			plan=new Plan();
			panelColapsado=true;
		}
	
	
		public void actionListenerColapsadoPanel() {
			panelColapsado=!panelColapsado;
		}
		
		public void actionListenerInsertarPlan() {
			try {
				managerPlan.insertarPlan(plan);
				listaPlan=managerPlan.findAllPlan();
				plan=new Plan();
				JSFUtil.createMensajeInfo("Plan ingresado correctamente");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.createMensajeError(e.getMessage());
				e.printStackTrace();
			}
		}
		public void actionListenerEliminarPlan(int id) {
			managerPlan.eliminarPlan(id);
			listaPlan=managerPlan.findAllPlan();
			JSFUtil.createMensajeInfo("Plan eliminado correctamente");
		}
		public void actionListenerSelecionarPlan(Plan plan) {
			planSeleccionado=plan;
		}
		public void actionListenerActualizarPlan() {
			try {
				managerPlan.actualizarPlan(planSeleccionado);
				listaPlan=managerPlan.findAllPlan();
				JSFUtil.createMensajeInfo("Datos Actualizados");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JSFUtil.createMensajeError(e.getMessage());
				e.printStackTrace();
			}
		}
		public ManagerPlan getManagerPlan() {
			return managerPlan;
		}
		public void setManagerPlan(ManagerPlan managerPlan) {
			this.managerPlan = managerPlan;
		}
		public List<Plan> getListaPlan() {
			return listaPlan;
		}
		public void setListaPlan(List<Plan> listaPlan) {
			this.listaPlan = listaPlan;
		}
		public Plan getPlan() {
			return plan;
		}
		public void setPlan(Plan plan) {
			this.plan = plan;
		}
		public boolean isPanelColapsado() {
			return panelColapsado;
		}
		public void setPanelColapsado(boolean panelColapsado) {
			this.panelColapsado = panelColapsado;
		}
		public Plan getPlanSeleccionado() {
			return planSeleccionado;
		}
		public void setPlanSeleccionado(Plan planSeleccionado) {
			this.planSeleccionado = planSeleccionado;
		}
		
		
		
		
}
