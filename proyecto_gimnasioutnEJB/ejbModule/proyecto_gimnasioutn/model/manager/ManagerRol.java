package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto_gimnasioutn.model.entities.Rol;


/**
 * Session Bean implementation class ManagerRol
 */
@Stateless
@LocalBean
public class ManagerRol {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerRol() {
        
    }
    
    public List<Rol>findAllRol(){
    	String consulta="select o from Rol o order by o.rId";
    	Query q=em.createQuery(consulta, Rol.class);
    	return q.getResultList();
    }
    public Rol findRolbyId(int id) {
    	return em.find(Rol.class, id);
    }
    public void insertarRol(Rol rol) throws Exception {
    	if (findRolbyId(rol.getRId())!=null)
    		throw new Exception("El rol especificado ya existe");
    	em.persist(rol);
    }
    public void eliminarRol(int id) {
    	Rol rol=findRolbyId(id);
    	if(rol!=null)
    		em.remove(rol);
    }
    public void actualizarRol(Rol rol) throws Exception {
    	Rol e=findRolbyId(rol.getRId());
    	if(e==null)
    		throw new Exception("No existe el rol especificado");
    	e.setRId(rol.getRId());
    	e.setRDescripcion(rol.getRDescripcion());
    	em.merge(e);
    }
    
}
