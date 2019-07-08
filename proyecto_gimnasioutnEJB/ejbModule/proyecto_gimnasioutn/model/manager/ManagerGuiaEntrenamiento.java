package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto_gimnasioutn.model.entities.GuiaEntrenamiento;

/**
 * Session Bean implementation class ManagerGuiaEntrenamiento
 */
@Stateless
@LocalBean
public class ManagerGuiaEntrenamiento {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerGuiaEntrenamiento() {
        // TODO Auto-generated constructor stub
    }
    
    public List<GuiaEntrenamiento> findAllGuiaEntrenamiento(){
    	String consulta= "select g from GuiaEntrenamiento g order by geId";
    	Query q=em.createQuery(consulta, GuiaEntrenamiento.class);
    	return q.getResultList();
    }
    
    public GuiaEntrenamiento findGuiaEntrenamientobyId(int geId) {
    	return em.find(GuiaEntrenamiento.class, geId);
    }
    public void insertarGuiaEntrenamiento(GuiaEntrenamiento guiaEntren) throws Exception {
    	if (findGuiaEntrenamientobyId(guiaEntren.getGeId())!=null)
    		throw new Exception("El GuiaEntrenamiento especificado ya existe");
    	em.persist(guiaEntren);
    }
    public void eliminarGuiaEntrenamiento(int geId) {
    	GuiaEntrenamiento guiaEntren=findGuiaEntrenamientobyId(geId);
    	if(guiaEntren!=null)
    		em.remove(guiaEntren);
    }
    public void actualizarGuiaEntrenamiento(GuiaEntrenamiento guiaEntren) throws Exception {
    	GuiaEntrenamiento e=findGuiaEntrenamientobyId(guiaEntren.getGeId());
    	if(e==null)
    		throw new Exception("No existe el GuiaEntrenamiento especificado");
    	e.setGeId(guiaEntren.getGeId());
    	e.setGeDescripcion(guiaEntren.getGeDescripcion());
    	em.merge(e);
    }

}