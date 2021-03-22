package projekt.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projekt.entities.Opinia;

@Stateless
public class OpiniaDAO {
	@PersistenceContext
	EntityManager em;
	public void create(Opinia opinia) {
		em.persist(opinia);
	}

	public Opinia merge(Opinia opinia) {
		return em.merge(opinia);
	}

	public void remove(Opinia opinia) {
		em.remove(em.merge(opinia));
	}

	public Opinia find(Object id) {
		return em.find(Opinia.class, id);
	}
	}

