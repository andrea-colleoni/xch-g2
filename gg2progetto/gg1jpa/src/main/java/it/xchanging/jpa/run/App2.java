package it.xchanging.jpa.run;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.xchanging.jpa.Genere;
import it.xchanging.jpa.Libro;

public class App2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("andrea");
		EntityManager em = emf.createEntityManager();
		
		Libro l = new Libro();
		l.setAutore("J.K. Rowling");
		l.setTitolo("Harry Potter....");
		l.setDataPubblicazione(new Date());
		
		l.setGenere(em.find(Genere.class, 2));
		
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
	}

}
