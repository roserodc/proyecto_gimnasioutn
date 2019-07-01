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
    	String consulta = "select o from Carrera o order by ca_id";
    	Query q = en.createQuery(consulta,Carrera.class);
    	return q.getResultList();
    }
    
    public Carrera findCarreraById(int id_ca) {
    	return en.find(Carrera.class, id_ca);
    }
    
    public void insertarCarrera(Carrera carrera) throws Exception{
    	if(findCarreraById(carrera.getCaId())!= null)
    		throw new Exception("Ya existe la carrera indicada");
    	en.persist(carrera);
    }
    
    public void eliminarCarrera(int id_ca) {
    	Carrera carrera =findCarreraById(id_ca);
    	if	(carrera!=null)
    		en.remove(carrera);
    }
    
    public void actualizarCarrera(Carrera carrera) throws Exception {
    	Carrera ca = findCarreraById(carrera.getCaId());
    	if(ca==null)
    		throw new Exception("No existe la carrera con el Id especificada");
    	ca.setCaDescripcion(carrera.getCaDescripcion());
    	ca.setCaAcronimo(carrera.getCaAcronimo());
    	ca.setFIdFacultad(carrera.getFIdFacultad());
    	en.merge(ca);
    }


}
