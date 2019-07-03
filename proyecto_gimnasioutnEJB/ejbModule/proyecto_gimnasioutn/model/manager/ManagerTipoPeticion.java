package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto_gimnasioutn.model.entities.TipoPeticion;


/**
 * Session Bean implementation class ManagerTipoPeticion
 */
@Stateless
@LocalBean
public class ManagerTipoPeticion {
	@PersistenceContext
	private EntityManager em;
    public ManagerTipoPeticion() {
        
    }
    
    public List<TipoPeticion> findAllTipoPeticion(){
    	String consulta="select o from TipoPeticion o order by o.tpId";
    	Query q=em.createQuery(consulta, TipoPeticion.class);
    	return q.getResultList();
    }
    public TipoPeticion findTipoPeticionbyId(int id) {
    	return em.find(TipoPeticion.class, id);
    }
    public void insertarTipoPeticion(TipoPeticion tipop) throws Exception {
    	if (findTipoPeticionbyId(tipop.getTpId())!=null)
    		throw new Exception("Ya existe el tipo de peticion especificado");
    	em.persist(tipop);
    }
    public void eliminarTipoPeticion(int id) {
    	TipoPeticion tipop=findTipoPeticionbyId(id);
    	if(tipop!=null)
    		em.remove(tipop);
    }
    public void actualizarTipoPeticion(TipoPeticion tipop) throws Exception {
    	TipoPeticion e=findTipoPeticionbyId(tipop.getTpId());
    	if(e==null)
    		throw new Exception("No existe el Tipo de Peticion Especificado");
    	e.setTpId(tipop.getTpId());
    	e.setTpDescripcion(tipop.getTpDescripcion());
    	em.merge(e);
    }
}
