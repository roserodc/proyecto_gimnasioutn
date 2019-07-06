package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto_gimnasioutn.model.entities.Peticione;

/**
 * Session Bean implementation class ManagerPeticiones
 */
@Stateless
@LocalBean
public class ManagerPeticiones {
	@PersistenceContext
	private EntityManager en;
    /**
     * Default constructor. 
     */
    public ManagerPeticiones() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Peticione> findAllPeticiones(){
    	String con = "SELECT p FROM Peticione p";
    	Query q = en.createQuery(con,Peticione.class);
    	return q.getResultList();
    }
    
    public Peticione findPeticionesById(int ptc_id) {
    	return en.find(Peticione.class, ptc_id);
    }
    
    public void insertarPeticiones(Peticione petic) throws Exception{
    	if(findPeticionesById(petic.getPtcId())!= null)
    		throw new Exception("Ya existe la peticion indicada");
    	en.persist(petic);
    }
    
    public void eliminarPeticione(int ptc_id) {
    	Peticione petic =findPeticionesById(ptc_id);
    	if	(petic!=null)
    		en.remove(petic);
    }
    
    public void actualizarPeticiones(Peticione petic) throws Exception {
    	Peticione pte = findPeticionesById(petic.getPtcId());
    	if(petic==null)
    		throw new Exception("No existe la carrera con el Id especificada");
    	pte.setPtcFecha(petic.getPtcFecha());
    	pte.setPtcHoraInicio(petic.getPtcHoraInicio());
    	pte.setPtcHoraFin(petic.getPtcHoraFin());
//    	pte.set(petic.getPtcFecha());
//    	pte.setPtcFecha(petic.getPtcFecha());
    	en.merge(pte);
    }
}
