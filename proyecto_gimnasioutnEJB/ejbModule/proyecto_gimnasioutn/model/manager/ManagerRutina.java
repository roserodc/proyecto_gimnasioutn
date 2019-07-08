package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import proyecto_gimnasioutn.model.entities.Rutina;

/**
 * Session Bean implementation class ManagerRutina
 */
@Stateless
@LocalBean
public class ManagerRutina {

	@PersistenceContext
	private EntityManager en;

	/**
	 * Default constructor.
	 */
	public ManagerRutina() {
		// TODO Auto-generated constructor stub
	}

	public List<Rutina> findAllRutinas() {
		String consulta = "select o from Rutina o order by rtDescripcion";
		Query q = en.createQuery(consulta, Rutina.class);
		return q.getResultList();
	}

	public Rutina findRutinaById(Integer rtid) {
		return en.find(Rutina.class, rtid);
	}
	
	public void insertarRutina(Rutina rutina) throws Exception{
    	if(findRutinaById(rutina.getRtId())!= null)
    		throw new Exception("Ya existe la rutina indicada");
    	en.persist(rutina);
    }
	
	public void eliminarRutina(int rtid) {
    	Rutina rutina =findRutinaById(rtid);
    	if	(rutina!=null)
    		en.remove(rutina);
    }
	
	public void actualizarRutina(Rutina rutina) throws Exception {
    	Rutina ru = findRutinaById(rutina.getRtId());
    	if(ru==null)
    		throw new Exception("No existe la rutina con el Id especificada");
    	ru.setRtId(rutina.getRtId());
    	ru.setRtDescripcion(rutina.getRtDescripcion());
    	ru.setRtSeries(rutina.getRtSeries());
    	ru.setRtRepeticiones(rutina.getRtRepeticiones());
    	ru.setRtDuracion(rutina.getRtDuracion());
    	en.merge(ru);
    }
}
