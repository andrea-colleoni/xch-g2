package it.xchanging.casestudy.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class JPATest {

	@Test
	public void testEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("case-study");
		EntityManager em = emf.createEntityManager();
	}

}
