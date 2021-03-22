package projekt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the u�ytkownik database table.
 * 
 */
@Entity
@NamedQuery(name="U�ytkownik.findAll", query="SELECT u FROM U�ytkownik u")
public class U�ytkownik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_u�ytkownika;

	private String email;

	private String has�o;

	@Column(name="histroria_usterek")
	private String histroriaUsterek;

	private String imi�;

	private String login;

	private String nazwisko;

	@Column(name="typ_u�ytkownika")
	private String typU�ytkownika;

	//bi-directional many-to-one association to Logowanie
	@OneToMany(mappedBy="u�ytkownik")
	private List<Logowanie> logowanies;

	//bi-directional many-to-one association to Opinia
	@OneToMany(mappedBy="u�ytkownik")
	private List<Opinia> opinias;

	public U�ytkownik() {
	}

	public int getID_u�ytkownika() {
		return this.ID_u�ytkownika;
	}

	public void setID_u�ytkownika(int ID_u�ytkownika) {
		this.ID_u�ytkownika = ID_u�ytkownika;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHas�o() {
		return this.has�o;
	}

	public void setHas�o(String has�o) {
		this.has�o = has�o;
	}

	public String getHistroriaUsterek() {
		return this.histroriaUsterek;
	}

	public void setHistroriaUsterek(String histroriaUsterek) {
		this.histroriaUsterek = histroriaUsterek;
	}

	public String getImi�() {
		return this.imi�;
	}

	public void setImi�(String imi�) {
		this.imi� = imi�;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getTypU�ytkownika() {
		return this.typU�ytkownika;
	}

	public void setTypU�ytkownika(String typU�ytkownika) {
		this.typU�ytkownika = typU�ytkownika;
	}

	public List<Logowanie> getLogowanies() {
		return this.logowanies;
	}

	public void setLogowanies(List<Logowanie> logowanies) {
		this.logowanies = logowanies;
	}

	public Logowanie addLogowany(Logowanie logowany) {
		getLogowanies().add(logowany);
		logowany.setU�ytkownik(this);

		return logowany;
	}

	public Logowanie removeLogowany(Logowanie logowany) {
		getLogowanies().remove(logowany);
		logowany.setU�ytkownik(null);

		return logowany;
	}

	public List<Opinia> getOpinias() {
		return this.opinias;
	}

	public void setOpinias(List<Opinia> opinias) {
		this.opinias = opinias;
	}

	public Opinia addOpinia(Opinia opinia) {
		getOpinias().add(opinia);
		opinia.setU�ytkownik(this);

		return opinia;
	}

	public Opinia removeOpinia(Opinia opinia) {
		getOpinias().remove(opinia);
		opinia.setU�ytkownik(null);

		return opinia;
	}

}