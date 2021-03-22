package projekt.DAO;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import projekt.entities.U퓓tkownik;



@Stateless
public class UzytkownikDAO {
	
	@PersistenceContext
	EntityManager em;
	public void create(U퓓tkownik uzytkownik) {
		em.persist(uzytkownik);
	}

	public U퓓tkownik merge(U퓓tkownik uzytkownik) {
		return em.merge(uzytkownik);
	}

	public void remove(U퓓tkownik uzytkownik) {
		em.remove(em.merge(uzytkownik));
	}

	public U퓓tkownik find(Object id) {
		return em.find(U퓓tkownik.class, id);
	}
	public List<U퓓tkownik> getFullList() {
		List<U퓓tkownik> list = null;

		Query query = em.createQuery("select p from Person p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<U퓓tkownik> getList(Map<String, Object> searchParams) {
		List<U퓓tkownik> list = null;

		// 1. Build query string with parameters
		String select = "select p ";
		String from = "from Person p ";
		String where = "";
		String orderby = "order by p.surname asc, p.name";

		// search for surname
		String surname = (String) searchParams.get("surname");
		if (surname != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.surname like :surname ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (surname != null) {
			query.setParameter("surname", surname+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of Person objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	}


