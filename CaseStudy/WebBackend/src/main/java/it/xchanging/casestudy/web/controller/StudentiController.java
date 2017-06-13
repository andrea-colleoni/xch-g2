package it.xchanging.casestudy.web.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.xchanging.casestudy.Studente;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping(path="/studente")
public class StudentiController {

	@Autowired
	EntityManager em;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Studente> elencoStudenti() { //@PathVariable("codFisc") String cf) {
		return em.createNamedQuery("studenti.all", Studente.class)
				//.setParameter("codiceFiscale", cf)
				.getResultList();
	}
	
	@RequestMapping(path="{codiceFiscale}", method=RequestMethod.POST)
	public @ResponseBody boolean salvaStudente(@PathVariable("codiceFiscale") String codFisc,  @RequestBody Studente s) {
		Studente db = em.find(Studente.class, codFisc);
		try {
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			return true;
		} catch (PersistenceException ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}
}
