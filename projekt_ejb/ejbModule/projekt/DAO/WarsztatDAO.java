package projekt.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projekt.entities.Warsztat;

@Stateless
public class WarsztatDAO {
	@PersistenceContext
	EntityManager em;
	public void create(Warsztat warsztat) {
		em.persist(warsztat);
	}

	public Warsztat merge(Warsztat warsztat) {
		return em.merge(warsztat);
	}

	public void remove(Warsztat warsztat) {
		em.remove(em.merge(warsztat));
	}

	public Warsztat find(Object id) {
		return em.find(Warsztat.class, id);
	}
	}

