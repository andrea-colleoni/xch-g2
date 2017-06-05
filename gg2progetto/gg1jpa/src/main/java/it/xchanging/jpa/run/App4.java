package it.xchanging.jpa.run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.xchanging.jpa.sakila.Actor;
import it.xchanging.jpa.sakila.Film;

public class App4 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sakila");
		EntityManager em = emf.createEntityManager();
		
		for(Film f : em.createQuery("select f from Film f", Film.class)
				.setMaxResults(10)
				.getResultList()) {
			System.out.println(f.getTitle());
			for(Actor a : f.getActors()) {
				System.out.println("\t" + a.getLastName());
			}
		}
	}

}
