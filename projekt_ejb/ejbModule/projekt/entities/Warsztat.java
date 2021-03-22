package projekt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the warsztat database table.
 * 
 */
@Entity
@Table(name = "warsztat")
@NamedQuery(name="Warsztat.findAll", query="SELECT w FROM Warsztat w")
public class Warsztat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int ID_warsztatu;

	@Column(name="kod_pocztowy")
	private String kodPocztowy;

	private String miejscowoœæ;

	@Column(name="nazwa_warsztatu")
	private String nazwaWarsztatu;

	private String nip;

	@Column(name="numer_domu")
	private String numerDomu;

	@Column(name="numer_telefonu")
	private int numerTelefonu;


	private String ulica;

	private String wojewodztwo;

	//bi-directional many-to-one association to Opinia
	@OneToMany(mappedBy="warsztat")
	private List<Opinia> opinias;

	public Warsztat() {
	}

	public Integer getID_warsztatu() {
		return this.ID_warsztatu;
	}

	public void setID_warsztatu(int ID_warsztatu) {
		this.ID_warsztatu = ID_warsztatu;
	}

	public String getKodPocztowy() {
		return this.kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getMiejscowoœæ() {
		return this.miejscowoœæ;
	}

	public void setMiejscowoœæ(String miejscowoœæ) {
		this.miejscowoœæ = miejscowoœæ;
	}

	public String getNazwaWarsztatu() {
		return this.nazwaWarsztatu;
	}

	public void setNazwaWarsztatu(String nazwaWarsztatu) {
		this.nazwaWarsztatu = nazwaWarsztatu;
	}



	public String getNumerDomu() {
		return this.numerDomu;
	}

	public void setNumerDomu(String numerDomu) {
		this.numerDomu = numerDomu;
	}

	public int getNumerTelefonu() {
		return this.numerTelefonu;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public void setNumerTelefonu(int numerTelefonu) {
		this.numerTelefonu = numerTelefonu;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getWojewodztwo() {
		return this.wojewodztwo;
	}

	public void setWojewodztwo(String wojewodztwo) {
		this.wojewodztwo = wojewodztwo;
	}

	public List<Opinia> getOpinias() {
		return this.opinias;
	}

	public void setOpinias(List<Opinia> opinias) {
		this.opinias = opinias;
	}

	public Opinia addOpinia(Opinia opinia) {
		getOpinias().add(opinia);
		opinia.setWarsztat(this);

		return opinia;
	}

	public Opinia removeOpinia(Opinia opinia) {
		getOpinias().remove(opinia);
		opinia.setWarsztat(null);

		return opinia;
	}

}