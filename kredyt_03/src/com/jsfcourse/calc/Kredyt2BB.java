package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static java.lang.Math.*;

import java.text.DecimalFormat;
@Named
@RequestScoped
//@SessionScoped
public class Kredyt2BB {
	private Double kwota;
	private Double lat;
	private Double procent;
	private double result;

	
	@Inject
	FacesContext ctx;
	


	public Double getKwota() {
		return kwota;
	}




	public void setKwota(Double kwota) {
		this.kwota = kwota;
	}




	public Double getLat() {
		return lat;
	}




	public void setLat(Double lat) {
		this.lat = lat;
	}




	public Double getProcent() {
		return procent;
	}




	public void setProcent(Double procent) {
		this.procent = procent;
	}




	public double getResult() {
		return result;
	}




	public void setResult(double result) {
		this.result = result;
	}




	public boolean rata () {
	

		try {
			
			double podziel=lat%0.5;
			if (podziel==0) {
			double miesiace = (12*lat);
		
			double q = 1+ (procent/(miesiace*100));
			
			double potega = pow(q,  miesiace);
			
			double wynik = kwota * potega *(q-1)/(potega-1);
			wynik *= 100;
			wynik = Math.round(wynik);
			wynik /= 100;
			
			result = wynik; }
			else {ctx.addMessage("lat", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Podaj lata z dok³adnoœci¹ do pó³ roku",null));
			return false;}
			
			ctx.addMessage("bla", new FacesMessage(FacesMessage.SEVERITY_INFO, "Wysokoœæ raty to: "+ result + " z³", null));
			return true;
		}
		catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Podaj liczby", null));
			return false;
			
		}
		
	}


	// Go to "showresult" if ok
	public String calc() {
		if(rata())
		{
			return "showresult";
		}
		
		return null;
	}
	 public String calc_AJAX() {
		if (rata()) {
		
		}
		return null;
	} 

	
}
