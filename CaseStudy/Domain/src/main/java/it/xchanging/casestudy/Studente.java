package it.xchanging.casestudy;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value= {
	@NamedQuery(name="studenti.all", query="select s from Studente s"),
	@NamedQuery(name="studenti.byCodFisc", query="select s from Studente s where s.codiceFiscale=:codiceFiscale")
})
public class Studente {
	
	String nome;
	String cognome;
	long matricola;
	@Id
	String codiceFiscale;
	Date dataNascita;
	
	@ManyToMany
	List<Corso> corsiFrequentati;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public long getMatricola() {
		return matricola;
	}
	public void setMatricola(long matricola) {
		this.matricola = matricola;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public List<Corso> getCorsiFrequentati() {
		return corsiFrequentati;
	}
	public void setCorsiFrequentati(List<Corso> corsiFrequentati) {
		this.corsiFrequentati = corsiFrequentati;
	}

}
