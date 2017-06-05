package it.xchanging.jpa.run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.xchanging.jpa.Genere;
import it.xchanging.jpa.Libro;

public class App3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("andrea");
		EntityManager em = emf.createEntityManager();
		
		for(Libro l : em.find(Genere.class, 2).getLibri()) {
			System.out.println(l.getTitolo());
			System.out.println(l.getCasaEditrice().getCitta());
		}
		
		for(Libro l : em
				.createNamedQuery("libro.perCitta", Libro.class)
				.setParameter("citta", "Milano")
				.getResultList()
				) {
			System.out.println(l.getTitolo());
		}

	}

}
