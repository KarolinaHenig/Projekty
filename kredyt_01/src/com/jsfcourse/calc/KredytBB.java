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
public class KredytBB {
	private String kwota;
	private String lat;
	private String procent;
	private double result;

	
	@Inject
	FacesContext ctx;

	public String getKwota() {
		return kwota;
	}




	public void setKwota(String kwota) {
		this.kwota = kwota;
	}




	public String getLat() {
		return lat;
	}




	public void setLat(String lat) {
		this.lat = lat;
	}




	public String getProcent() {
		return procent;
	}




	public void setProcent(String procent) {
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
			double kwota = Double.parseDouble(this. kwota);
			double lat = Double.parseDouble(this. lat);
			double procent = Double.parseDouble(this. procent);
			
			double miesiace = (12*lat);
			
			double q = 1+ (procent/(miesiace*100));
			
			double potega = pow(q,  miesiace);
			
			double wynik = kwota * potega *(q-1)/(potega-1);
			wynik *= 100;
			wynik = Math.round(wynik);
			wynik /= 100;
			
			result = wynik;
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wysokoœæ raty to:", null));
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

	
}
