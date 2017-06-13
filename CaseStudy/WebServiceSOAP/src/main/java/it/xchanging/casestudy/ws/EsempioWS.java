package it.xchanging.casestudy.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.xchanging.casestudy.Studente;

@WebService
public interface EsempioWS {

	@WebMethod
	List<Studente> elencoStudenti();
}
