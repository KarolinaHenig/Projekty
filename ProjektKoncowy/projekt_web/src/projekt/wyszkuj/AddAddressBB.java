package projekt.wyszkuj; 

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


import projekt.DAO.WarsztatDAO;
import projekt.entities.Warsztat;

@Named
@ViewScoped
public class AddAddressBB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private static final String PAGE_ADDRESS_LIST = "listAddress?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	
	
	private Warsztat warsztat = new Warsztat();
	private Warsztat loaded = null;
	@EJB
	WarsztatDAO warsztatDAO;
	

	@Inject
	FacesContext context;

	@Inject
	Flash flash;
	
	public Warsztat getWarsztat() {
		return warsztat;
	}

	public void onLoad() throws IOException {
		
		
		loaded = (Warsztat) flash.get("warsztat");

		
		if (loaded != null) {
			warsztat = loaded;
			
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³¹d u¿ycia systemu", null));
			
		}

	}

	public String newWarsztat(){
		Warsztat warsztat = new Warsztat();
		
		
		
		flash.put("warsztat", warsztat);
		
		return PAGE_ADDRESS_LIST ;
	}

	public String saveData() {
		
		if (loaded == null) {
			return PAGE_STAY_AT_THE_SAME;
		}

		try {
			if (warsztat.getID_warsztatu() == null) {
				
				warsztatDAO.create(warsztat);
			} else {
				
				warsztatDAO.merge(warsztat);
			}
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wyst¹pi³ b³¹d podczas zapisu", null));
			return PAGE_STAY_AT_THE_SAME;
		}

		return PAGE_ADDRESS_LIST ;
	}
	
}


