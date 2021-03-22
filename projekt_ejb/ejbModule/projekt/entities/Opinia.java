package projekt.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the opinia database table.
 * 
 */
@Entity
@NamedQuery(name="Opinia.findAll", query="SELECT o FROM Opinia o")
public class Opinia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_opinii;

	private String tekst;

	private String tytu³;

	//bi-directional many-to-one association to U¿ytkownik
	@ManyToOne
	@JoinColumn(name="u¿ytkownikID_u¿ytkownika")
	private U¿ytkownik u¿ytkownik;

	//bi-directional many-to-one association to Warsztat
	@ManyToOne
	@JoinColumn(name="warsztatID")
	private Warsztat warsztat;

	public Opinia() {
	}

	public int getID_opinii() {
		return this.ID_opinii;
	}

	public void setID_opinii(int ID_opinii) {
		this.ID_opinii = ID_opinii;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public String getTytu³() {
		return this.tytu³;
	}

	public void setTytu³(String tytu³) {
		this.tytu³ = tytu³;
	}

	public U¿ytkownik getU¿ytkownik() {
		return this.u¿ytkownik;
	}

	public void setU¿ytkownik(U¿ytkownik u¿ytkownik) {
		this.u¿ytkownik = u¿ytkownik;
	}

	public Warsztat getWarsztat() {
		return this.warsztat;
	}

	public void setWarsztat(Warsztat warsztat) {
		this.warsztat = warsztat;
	}

}