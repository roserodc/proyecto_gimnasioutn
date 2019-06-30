package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto_gimnasioutn.model.entities.Carrera;

/**
 * Session Bean implementation class ManagerCarrera
 */
@Stateless
@LocalBean
public class ManagerCarrera {
	@PersistenceContext
	private EntityManager en;

    /**
     * Default constructor. 
     */
    public ManagerCarrera() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Carrera> findAllCarreras(){
    	String consulta = "select o from Carrera o";
    	Query q = en.createQuery(consulta,Carrera.class);
    	return q.getResultList();
    }

}
