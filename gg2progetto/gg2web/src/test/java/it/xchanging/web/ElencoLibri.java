package it.xchanging.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.xchanging.jpa.Libro;

@WebServlet("/ElencoLibri")
public class ElencoLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ElencoLibri() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("andrea");
		EntityManager em = emf.createEntityManager();
		List<Libro> lista = em.createQuery("select l from Libro l", Libro.class).getResultList();
		request.setAttribute("libri",  lista);
		request.getRequestDispatcher("WEB-INF/jsp/elencoLibri.jsp").forward(request, response);
	}

}
