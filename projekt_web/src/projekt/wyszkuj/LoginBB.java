package projekt.wyszkuj;
/* package com.jsfcourse.calc;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import projekt.DAO.UzytkownikDAO;
import projekt.entities.U¿ytkownik;

@Named
@ViewScoped
public class LoginBB implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String PAGE_PERSON_LIST = "personList?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private U¿ytkownik uzytkownik = new U¿ytkownik();
	private U¿ytkownik loaded = null;

	@EJB
	UzytkownikDAO uzytkownikDAO;

	@Inject
	FacesContext context;

	@Inject
	Flash flash;

	public U¿ytkownik getU¿ytkownik() {
		return uzytkownik;
	}

	public void onLoad() throws IOException {
		// 1. load person passed through session
		// HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		// loaded = (Person) session.getAttribute("person");

		// 2. load person passed through flash
		loaded = (U¿ytkownik) flash.get("u¿ytkownik");

		// cleaning: attribute received => delete it from session
			uzytkownik = loaded;
			// session.removeAttribute("person");
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³¹d u¿ycia systemu", null));
			// if (!context.isPostback()) { //possible redirect
			// context.getExternalContext().redirect("personList.xhtml");
			// context.responseComplete();
			// }
		}

	}

	public String saveData() {
		// no Person object passed
		if (loaded == null) {
			return PAGE_STAY_AT_THE_SAME;
		}

		try {
			if (u¿ytkownik.getIdu¿ytkownika() == null) {
				// new record
				UzytkownikDAO.create(u¿ytkownik);
			} else {
				// existing record
				UzytkownikDAO.merge(uzytkownik);
			}
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "wyst¹pi³ b³¹d podczas zapisu", null));
			return PAGE_STAY_AT_THE_SAME;
		}

		return PAGE_PERSON_LIST;
	}
}
*/