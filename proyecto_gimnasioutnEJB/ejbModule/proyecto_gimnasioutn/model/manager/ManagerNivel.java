package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto_gimnasioutn.model.entities.Nivel;

/**
 * Session Bean implementation class ManagerNivel
 */
@Stateless
@LocalBean
public class ManagerNivel {
	@PersistenceContext
	private EntityManager em;
	public ManagerNivel() {
        
    }
	
	public List<Nivel> findAllNivel(){
		String consulta="select o from Nivel o order by o.niId";
		Query q=em.createQuery(consulta, Nivel.class);
		return q.getResultList();
	}
	public Nivel findNivelbyId(int id) {
		return em.find(Nivel.class, id);
	}
	
	public void insertarNivel(Nivel nivel) throws Exception {
		if (findNivelbyId(nivel.getNiId())!=null)
			throw new Exception("Ya existe el nivel seleccionado");
		em.persist(nivel);
	}
	public void eliminarNivel(int id) {
		Nivel nivel=findNivelbyId(id);
		if(nivel!=null)
			em.remove(nivel);
	}
	public void actualizarNivel(Nivel nivel) throws Exception {
		Nivel e=findNivelbyId(nivel.getNiId());
		if(e==null)
			throw new Exception("No existe el Nivel especificado");
		e.setNiId(nivel.getNiId());
		e.setNiDescripcion(nivel.getNiDescripcion());
		em.merge(e);
	}
}
