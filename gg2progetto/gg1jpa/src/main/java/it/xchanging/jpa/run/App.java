package it.xchanging.jpa.run;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.xchanging.jpa.Genere;
import it.xchanging.jpa.Libro;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("andrea");
		EntityManager em = emf.createEntityManager();
		
		Genere g = new Genere();
		g.setNome("Drammatico");
		g.setDescrizione("Libri drammatico");
		
		Libro l = new Libro();
		l.setAutore("Dante Alighieri");
		l.setDataPubblicazione(new Date());
		l.setGenere(g);
		//g.setLibri(new ArrayList<>());
		//g.getLibri().add(l);
		l.setTitolo("La ........");

		em.getTransaction().begin();
		// em.persist(g); // dovrebbe persistere da solo 
		em.persist(l);
		em.getTransaction().commit();
	}

}
