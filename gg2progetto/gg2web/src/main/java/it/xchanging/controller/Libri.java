package it.xchanging.controller;

import java.util.List;

import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import it.xchanging.jpa.Libro;

@Controller
public class Libri {
	
	@Autowired
	private EntityManager em;
	//....
	
	@RequestMapping(value="/DatiElencoLibri", method = RequestMethod.GET)
	public @ResponseBody List<Libro> elencoLibri(){
		return em.createQuery("select l from Libro l", Libro.class)
				.setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache)
				.setHint(QueryHints.CACHE_RETRIEVE_MODE, CacheRetrieveMode.BYPASS)
				.getResultList();
	}
	
	// ggg
	@RequestMapping(value="/nuovoLibro", method = RequestMethod.PUT)
	public @ResponseBody boolean inserisciLibro(@RequestBody Libro l) {
		try {
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
		} catch (PersistenceException ex) {
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/ElencoLibri", method = RequestMethod.GET)
	public ModelAndView elencoLibriJsp() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elencoLibri");
		mv.addObject("libri", elencoLibri());
		return mv;
	}

}
