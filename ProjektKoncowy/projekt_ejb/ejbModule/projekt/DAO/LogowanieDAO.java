package projekt.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projekt.entities.Logowanie;

@Stateless
public class LogowanieDAO {
	@PersistenceContext
	EntityManager em;
	public void create(Logowanie logowanie) {
		em.persist(logowanie);
	}

	public Logowanie merge(Logowanie logowanie) {
		return em.merge(logowanie);
	}

	public void remove(Logowanie logowanie) {
		em.remove(em.merge(logowanie));
	}

	public Logowanie find(Object id) {
		return em.find(Logowanie.class, id);
	}
	}

