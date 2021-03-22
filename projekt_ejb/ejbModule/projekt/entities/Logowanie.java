package projekt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the logowanie database table.
 * 
 */
@Entity
@NamedQuery(name="Logowanie.findAll", query="SELECT l FROM Logowanie l")
public class Logowanie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_logowania;

	@Temporal(TemporalType.DATE)
	private Date data;

	//bi-directional many-to-one association to Użytkownik
	@ManyToOne
	@JoinColumn(name="użytkownikID")
	private Użytkownik użytkownik;

	public Logowanie() {
	}

	public int getID_logowania() {
		return this.ID_logowania;
	}

	public void setID_logowania(int ID_logowania) {
		this.ID_logowania = ID_logowania;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Użytkownik getUżytkownik() {
		return this.użytkownik;
	}

	public void setUżytkownik(Użytkownik użytkownik) {
		this.użytkownik = użytkownik;
	}

}