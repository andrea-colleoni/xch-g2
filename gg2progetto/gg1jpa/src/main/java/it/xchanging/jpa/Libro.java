package it.xchanging.jpa;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
	@NamedQuery(name="libro.perCitta", query="select l from Libro l where l.casaEditrice.citta=:citta")
})
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String titolo;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Genere genere;
	
	private String autore;
	
	private Date dataPubblicazione;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="casa_id")
	private CasaEditrice casaEditrice;
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Genere getGenere() {
		return genere;
	}
	public void setGenere(Genere genere) {
		// genere.getLibri().add(this);
		this.genere = genere;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}
	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}
	public CasaEditrice getCasaEditrice() {
		return casaEditrice;
	}
	public void setCasaEditrice(CasaEditrice casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

}
