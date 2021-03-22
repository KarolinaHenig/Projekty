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
public class ListAddressBB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private static final String PAGE_ADDRESS_LIST = "listAddress?faces-redirect=true";
	private static final String PAGE_ADDRESS_EDIT = "editAddress?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;	

	@Inject
	FacesContext context;

	@Inject
	Flash flash;
	
	
	public String newAddress() {
		
		Warsztat warsztat= new Warsztat();
		
		flash.put("warsztat", warsztat);
		return PAGE_ADDRESS_EDIT;
	} 
	
}


