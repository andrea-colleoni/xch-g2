package it.xchanging.casestudy.ws;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.xchanging.casestudy.Studente;

@WebService(endpointInterface="it.xchanging.casestudy.ws.EsempioWS")
public class EsempioWSImpl implements EsempioWS {

	public List<Studente> elencoStudenti() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("case-study");
		EntityManager em =emf.createEntityManager();
		return em.createNamedQuery("studenti.all", Studente.class).getResultList();
	}

}
