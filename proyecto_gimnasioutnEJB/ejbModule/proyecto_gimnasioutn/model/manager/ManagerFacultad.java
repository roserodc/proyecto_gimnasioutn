package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto_gimnasioutn.model.entities.Facultad;

/**
 * Session Bean implementation class ManagerFacultad
 */
@Stateless
@LocalBean
public class ManagerFacultad {
	@PersistenceContext
	private EntityManager en;
    /**
     * Default constructor. 
     */
    public ManagerFacultad() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Facultad> findAllFacultades(){
    	String con = "select o from Facultad o order by f_id";
    	Query q= en.createQuery(con,Facultad.class);
    	return q.getResultList();
    }
    
    public Facultad findFacultadById(int id_facu) {
    	return en.find(Facultad.class, id_facu);
    }
    
    public void insertarFacultad(Facultad facultad) throws Exception{
    	if(findFacultadById(facultad.getFId())!= null)
    		throw new Exception("Ya existe la carrera indicada");
    	en.persist(facultad);
    }
    
    public void eliminarFacultad(int id_facu) {
    	Facultad facultad =findFacultadById(id_facu);
    	if	(facultad!=null)
    		en.remove(facultad);
    }
    
    public void actualizarFacultad(Facultad facultad) throws Exception {
    	Facultad fac = findFacultadById(facultad.getFId());
    	if(facultad==null)
    		throw new Exception("No existe la facultad con el Id especificada");
    	fac.setFDescripcion(facultad.getFDescripcion());
    	fac.setFAcronimo(facultad.getFAcronimo());
    	en.merge(fac);
    }
}

