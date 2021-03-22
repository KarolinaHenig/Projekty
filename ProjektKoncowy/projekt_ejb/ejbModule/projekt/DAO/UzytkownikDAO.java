package projekt.DAO;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import projekt.entities.Użytkownik;



@Stateless
public class UzytkownikDAO {
	
	@PersistenceContext
	EntityManager em;
	public void create(Użytkownik uzytkownik) {
		em.persist(uzytkownik);
	}

	public Użytkownik merge(Użytkownik uzytkownik) {
		return em.merge(uzytkownik);
	}

	public void remove(Użytkownik uzytkownik) {
		em.remove(em.merge(uzytkownik));
	}

	public Użytkownik find(Object id) {
		return em.find(Użytkownik.class, id);
	}
	public List<Użytkownik> getFullList() {
		List<Użytkownik> list = null;

		Query query = em.createQuery("select p from Person p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Użytkownik> getList(Map<String, Object> searchParams) {
		List<Użytkownik> list = null;

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


