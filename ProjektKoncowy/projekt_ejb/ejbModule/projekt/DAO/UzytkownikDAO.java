package projekt.DAO;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import projekt.entities.U�ytkownik;



@Stateless
public class UzytkownikDAO {
	
	@PersistenceContext
	EntityManager em;
	public void create(U�ytkownik uzytkownik) {
		em.persist(uzytkownik);
	}

	public U�ytkownik merge(U�ytkownik uzytkownik) {
		return em.merge(uzytkownik);
	}

	public void remove(U�ytkownik uzytkownik) {
		em.remove(em.merge(uzytkownik));
	}

	public U�ytkownik find(Object id) {
		return em.find(U�ytkownik.class, id);
	}
	public List<U�ytkownik> getFullList() {
		List<U�ytkownik> list = null;

		Query query = em.createQuery("select p from Person p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<U�ytkownik> getList(Map<String, Object> searchParams) {
		List<U�ytkownik> list = null;

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


