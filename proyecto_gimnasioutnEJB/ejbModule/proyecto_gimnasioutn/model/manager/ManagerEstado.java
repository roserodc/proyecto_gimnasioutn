package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto_gimnasioutn.model.entities.Estado;

/**
 * Session Bean implementation class ManagerEstado
 */
@Stateless
@LocalBean
public class ManagerEstado {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerEstado() {
        
    }
    
    public List<Estado> findAllEstado(){
    	String consulta="select o from Estado o";
    	Query q=em.createQuery(consulta, Estado.class);
    	return q.getResultList();
    }
    public Estado findEstadobyId(int id) {
    	return em.find(Estado.class, id);
    }
    public void insertarEstado(Estado estado) throws Exception {
    	if (findEstadobyId(estado.getEstId())!=null)
    		throw new Exception("Ya existe el estado indicado.");
    	em.persist(estado);
    }
    public void eliminarEstado(int id) {
    	Estado estado=findEstadobyId(id);
    	if (estado!=null)
    		em.remove(estado);
    }
    public void actualizarEstado(Estado estado) throws Exception {
    	Estado e=findEstadobyId(estado.getEstId());
    	if(e==null)
    		throw new Exception("No existe tal estado");
    	e.setEstId(estado.getEstId());
    	e.setEstDescripcion(estado.getEstDescripcion());
    	em.merge(e);
    }

}
