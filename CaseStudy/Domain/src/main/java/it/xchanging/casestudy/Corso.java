package it.xchanging.casestudy;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idCorso;
	
	String titolo;
	int durataInOre;
	Date dataInizio;
	Date dataFine;
	
	@ManyToMany(mappedBy="corsiFrequentati")
	List<Studente> studentiFrequentanti;
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getDurataInOre() {
		return durataInOre;
	}
	public void setDurataInOre(int durataInOre) {
		this.durataInOre = durataInOre;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public List<Studente> getStudentiFrequentanti() {
		return studentiFrequentanti;
	}
	public void setStudentiFrequentanti(List<Studente> studentiFrequentanti) {
		this.studentiFrequentanti = studentiFrequentanti;
	}
}
