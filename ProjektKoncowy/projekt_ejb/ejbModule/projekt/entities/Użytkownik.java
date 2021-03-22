package projekt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the użytkownik database table.
 * 
 */
@Entity
@NamedQuery(name="Użytkownik.findAll", query="SELECT u FROM Użytkownik u")
public class Użytkownik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_użytkownika;

	private String email;

	private String hasło;

	@Column(name="histroria_usterek")
	private String histroriaUsterek;

	private String imię;

	private String login;

	private String nazwisko;

	@Column(name="typ_użytkownika")
	private String typUżytkownika;

	//bi-directional many-to-one association to Logowanie
	@OneToMany(mappedBy="użytkownik")
	private List<Logowanie> logowanies;

	//bi-directional many-to-one association to Opinia
	@OneToMany(mappedBy="użytkownik")
	private List<Opinia> opinias;

	public Użytkownik() {
	}

	public int getID_użytkownika() {
		return this.ID_użytkownika;
	}

	public void setID_użytkownika(int ID_użytkownika) {
		this.ID_użytkownika = ID_użytkownika;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHasło() {
		return this.hasło;
	}

	public void setHasło(String hasło) {
		this.hasło = hasło;
	}

	public String getHistroriaUsterek() {
		return this.histroriaUsterek;
	}

	public void setHistroriaUsterek(String histroriaUsterek) {
		this.histroriaUsterek = histroriaUsterek;
	}

	public String getImię() {
		return this.imię;
	}

	public void setImię(String imię) {
		this.imię = imię;
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

	public String getTypUżytkownika() {
		return this.typUżytkownika;
	}

	public void setTypUżytkownika(String typUżytkownika) {
		this.typUżytkownika = typUżytkownika;
	}

	public List<Logowanie> getLogowanies() {
		return this.logowanies;
	}

	public void setLogowanies(List<Logowanie> logowanies) {
		this.logowanies = logowanies;
	}

	public Logowanie addLogowany(Logowanie logowany) {
		getLogowanies().add(logowany);
		logowany.setUżytkownik(this);

		return logowany;
	}

	public Logowanie removeLogowany(Logowanie logowany) {
		getLogowanies().remove(logowany);
		logowany.setUżytkownik(null);

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
		opinia.setUżytkownik(this);

		return opinia;
	}

	public Opinia removeOpinia(Opinia opinia) {
		getOpinias().remove(opinia);
		opinia.setUżytkownik(null);

		return opinia;
	}

}