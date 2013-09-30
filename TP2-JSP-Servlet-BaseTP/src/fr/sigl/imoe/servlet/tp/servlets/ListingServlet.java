package fr.sigl.imoe.servlet.tp.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.sigl.imoe.servlet.tp.bo.Evenement;
import fr.sigl.imoe.servlet.tp.dao.DAOFactory;
import fr.sigl.imoe.servlet.tp.dao.EvenementDAO;
import fr.sigl.imoe.servlet.tp.dao.hibernate.HibernateDAOFactory;

/**
 * Servlet permettant d'initialiser la liste des événements
 * existant dans la base de données.
 */
@WebServlet(
        name = "ListingServlet",
        urlPatterns = {"/listing", "/show/*", "/edit/*", "/delete/*", "/add"}
)
public class ListingServlet extends HttpServlet {
    /**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 8814373079661691995L;

	/**
     * Logger JUL.
     */
    public static final Logger LOGGER = Logger.getLogger(ListingServlet.class.getName());

    /**
     * Surcharge de la méthode service qui effectue les traitements indépendamment du type de requète.
     *
     * @param request               La requète HTTP.
     * @param response              La réponse HTTP.
     * @throws ServletException     Exception générique pour le traitement de la servlet.
     * @throws IOException          Exception générique d'entrée / sortie.
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectName = "/TP2-JSP-Servlet-BaseTP/";
		String shortURI = request.getRequestURI().substring(projectName.length());
		
		try {
			if (shortURI.equals("listing"))
			{
				DAOFactory DAOFact = DAOFactory.getDAOFactory();
				EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
				List<Evenement> events = EvenementDAO.getEvenements();
				for (Evenement e : events) {
					System.out.println(e.getTitre());
				}
				request.setAttribute("eventList", events);
		
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher("/accueil.jsp");
				dispacher.forward(request, response);
				DAOFact.close();
			}
			
			if (shortURI.startsWith("show"))
			{
				String id = shortURI.substring("show/".length());
				DAOFactory DAOFact = DAOFactory.getDAOFactory();
				EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
				List<Evenement> events = EvenementDAO.getEvenements();
				for (Evenement e : events) {
					System.out.println(e.getTitre());
				}
				request.setAttribute("eventList", events);
		
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher("/accueil.jsp");
				dispacher.forward(request, response);
				DAOFact.close();
			}
			
			if (shortURI.startsWith("edit"))
			{
				String id = shortURI.substring("edit/".length());
				DAOFactory DAOFact = DAOFactory.getDAOFactory();
				EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
				List<Evenement> events = EvenementDAO.getEvenements();
				for (Evenement e : events) {
					System.out.println(e.getTitre());
				}
				request.setAttribute("eventList", events);
		
				RequestDispatcher dispacher = getServletContext().getRequestDispatcher("/accueil.jsp");
				dispacher.forward(request, response);
				DAOFact.close();
			}
			
			if (shortURI.startsWith("delete"))
			{
				String id = shortURI.substring("delete/".length());
				DAOFactory DAOFact = DAOFactory.getDAOFactory();
				EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
				Evenement event = EvenementDAO.getEvenement(id);
				if (!event.equals(null))
					EvenementDAO.deleteEvenement(event);
				DAOFact.close();
				
				response.sendRedirect(projectName + "listing");
				
			}
			
			if (shortURI.equals("add"))
			{
				response.sendRedirect(projectName + "add.jsp");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

    }
}
