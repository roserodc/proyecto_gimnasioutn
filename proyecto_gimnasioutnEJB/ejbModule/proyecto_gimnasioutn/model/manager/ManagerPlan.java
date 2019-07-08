package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import proyecto_gimnasioutn.model.entities.Plan;


/**
 * Session Bean implementation class ManagerPlan
 */
@Stateless
@LocalBean
public class ManagerPlan {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerPlan() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Plan>findAllPlan(){
    	String consulta="select o from Plan o order by pl_id ";
    	Query q=em.createQuery(consulta, Plan.class);
    	return q.getResultList();
    }
    public Plan findPlanbyId(int id) {
    	return em.find(Plan.class, id);
    }
    public void insertarPlan(Plan plan) throws Exception {
    	if (findPlanbyId(plan.getPlId())!=null)
    		throw new Exception("El plan especificado ya existe");
    	em.persist(plan);
    }
    public void eliminarPlan(int id) {
    	Plan plan=findPlanbyId(id);
    	if(plan!=null)
    		em.remove(plan);
    }
    public void actualizarPlan(Plan plan) throws Exception {
    	Plan e=findPlanbyId(plan.getPlId());
    	if(e==null)
    		throw new Exception("No existe el Plan especificado");
    	e.setPlId(plan.getPlId());
    	e.setPlTipo(plan.getPlTipo());
    	e.setGeIdGuiaEntrenamiento(plan.getGeIdGuiaEntrenamiento());
    	em.merge(e);
    }
    

}