package proyecto_gimnasioutn.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto_gimnasioutn.model.entities.Club;

/**
 * Session Bean implementation class ManagerClub
 */
@Stateless
@LocalBean
public class ManagerClub {
	@PersistenceContext
	private EntityManager en;
    /**
     * Default constructor. 
     */
    public ManagerClub() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Club> findAllClubes(){
    	String con = "select o from Club o  order by clu_id";
    	Query q= en.createQuery(con,Club.class);
    	return q.getResultList();
    }
    
    public Club findClubById(int id_club) {
    	return en.find(Club.class, id_club);
    }
    
    public void insertarClub(Club club) throws Exception{
    	if(findClubById(club.getCluId())!= null)
    		throw new Exception("Ya existe la carrera indicada");
    	en.persist(club);
    }
    
    public void eliminarClub(int id_club) {
    	Club club =findClubById(id_club);
    	if	(club!=null)
    		en.remove(club);
    }
    
    public void actualizarClub(Club club) throws Exception {
    	Club clu = findClubById(club.getCluId());
    	if(club==null)
    		throw new Exception("No existe la carrera con el Id especificada");
    	clu.setCluDescripcion(club.getCluDescripcion());
    	en.merge(clu);
    }

}
