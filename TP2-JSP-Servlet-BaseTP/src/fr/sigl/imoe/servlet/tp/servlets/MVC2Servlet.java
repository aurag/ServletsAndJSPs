package fr.sigl.imoe.servlet.tp.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.sigl.imoe.servlet.tp.bo.Evenement;
import fr.sigl.imoe.servlet.tp.bo.TypeEvenement;
import fr.sigl.imoe.servlet.tp.dao.DAOFactory;
import fr.sigl.imoe.servlet.tp.dao.EvenementDAO;
import fr.sigl.imoe.servlet.tp.dao.TypeEvenementDAO;
import fr.sigl.imoe.servlet.tp.dao.exceptions.DAOConfigureException;
import fr.sigl.imoe.servlet.tp.dao.exceptions.DAORequestException;
import fr.sigl.imoe.servlet.tp.dao.hibernate.HibernateDAOFactory;

/**
 * Servlet permettant d'initialiser la liste des événements existant dans la
 * base de données.
 */
@WebServlet(name = "MVC2Servlet", urlPatterns = { "/listing", "/show",
		"/edit", "/delete/*", "/add", "/addEvent", "/editEvent" })
public class MVC2Servlet extends HttpServlet {
	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 8814373079661691995L;

	/**
	 * Logger JUL.
	 */
	public static final Logger LOGGER = Logger.getLogger(MVC2Servlet.class
			.getName());

	/**
	 * Surcharge de la méthode service qui effectue les traitements
	 * indépendamment du type de requête.
	 * 
	 * @param request
	 *            La requête HTTP.
	 * @param response
	 *            La réponse HTTP.
	 * @throws ServletException
	 *             Exception générique pour le traitement de la servlet.
	 * @throws IOException
	 *             Exception générique d'entrée / sortie.
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String projectName = "/TP2-JSP-Servlet-BaseTP/";

		String shortURI = request.getRequestURI().substring(
				projectName.length());
		try {
			if (shortURI.equals("listing")) {
				loadHomePage(request, response);
			}

			if (shortURI.startsWith("show")) {
				loadShowPage(request, response);
			}

			if (shortURI.equals("edit")) {
				loadEditPage(request, response);
			}

			if (shortURI.startsWith("delete")) {
				deleteEvent(request, response, shortURI, projectName);
			}

			if (shortURI.equals("add")) {
				loadAddPage(request, response);
			}

			if (shortURI.equals("addEvent")) {
				validateAddEvent(request, response, projectName);
			}

			if (shortURI.equals("editEvent")) {
				validateEventEdition(request, response, projectName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void deleteEvent(HttpServletRequest request, 
			HttpServletResponse response, String shortURI, String projectName)
			throws ServletException, DAOConfigureException,
			DAORequestException, IOException {
		String id = shortURI.substring("delete/".length());
		DAOFactory DAOFact = DAOFactory.getDAOFactory();
		EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
		Evenement event = EvenementDAO.getEvenement(id);
		if (!event.equals(null))
			EvenementDAO.deleteEvenement(event);
		DAOFact.close();

		request.setAttribute("message", "Événement supprimé");
		response.sendRedirect(projectName + "listing");
	}

	private void loadHomePage(HttpServletRequest request,
			HttpServletResponse response) throws DAOConfigureException,
			DAORequestException, ServletException, IOException {
		DAOFactory DAOFact = DAOFactory.getDAOFactory();
		EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
		List<Evenement> events = EvenementDAO.getEvenements();
		DAOFact.close();

		request.setAttribute("eventList", events);

		RequestDispatcher dispacher = getServletContext().getRequestDispatcher(
				"/accueil.jsp");
		dispacher.forward(request, response);
	}

	private void loadShowPage(HttpServletRequest request,
			HttpServletResponse response) throws DAOConfigureException,
			DAORequestException, ServletException, IOException {
		String id = request.getParameter("id");
		DAOFactory DAOFact = DAOFactory.getDAOFactory();
		EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
		Evenement event = EvenementDAO.getEvenement(id);
		DAOFact.close();
		request.setAttribute("event", event);

		RequestDispatcher dispacher = getServletContext().getRequestDispatcher(
				"/show.jsp");
		dispacher.forward(request, response);
	}

	@SuppressWarnings("deprecation")
	private void validateAddEvent(HttpServletRequest request,
			HttpServletResponse response, String projectName)
			throws DAOConfigureException, DAORequestException,
			ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String type = request.getParameter("type");
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate = formatter
					.parse(request.getParameter("start_date"));
			startDate.setHours(Integer.parseInt(request
					.getParameter("start_date_hour")));
			startDate.setMinutes(Integer.parseInt(request
					.getParameter("start_date_min")));

			Date endDate = formatter.parse(request.getParameter("end_date"));
			endDate.setHours(Integer.parseInt(request
					.getParameter("end_date_hour")));
			endDate.setMinutes(Integer.parseInt(request
					.getParameter("end_date_min")));

			Timestamp start_date = new Timestamp(startDate.getTime());
			Timestamp end_date = new Timestamp(endDate.getTime());

			String description = request.getParameter("description");

			DAOFactory DAOFact = DAOFactory.getDAOFactory();
			EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
			TypeEvenementDAO typeEvenementDAO = DAOFact.getTypeEvenementDAO();
			Evenement event = new Evenement();
			event.setTitre(title);
			event.setType(typeEvenementDAO.getTypeEvenement(type));
			event.setDateDebut(start_date);
			event.setDateFin(end_date);
			event.setDescription(description);
			EvenementDAO.insertEvenement(event);
			DAOFact.close();
			request.setAttribute("message", "Événement correctement ajouté");
			loadHomePage(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "Erreur dans le formatage de la date");
			loadAddPage(request, response);
		}
	}

	private void loadAddPage(HttpServletRequest request,
			HttpServletResponse response) throws DAOConfigureException,
			DAORequestException, ServletException, IOException {
		DAOFactory DAOFact = DAOFactory.getDAOFactory();
		TypeEvenementDAO typeEvenementDAO = DAOFact.getTypeEvenementDAO();
		List<TypeEvenement> typeList = typeEvenementDAO.getTypesEvenements();
		request.setAttribute("typeList", typeList);
		DAOFact.close();

		RequestDispatcher dispacher = getServletContext().getRequestDispatcher(
				"/add.jsp");
		dispacher.forward(request, response);
	}

	@SuppressWarnings("deprecation")
	private void validateEventEdition(HttpServletRequest request,
			HttpServletResponse response, String projectName)
			throws DAOConfigureException, DAORequestException,
			ServletException, IOException {
		String title = request.getParameter("title");
		String type = request.getParameter("type");

		try {

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate = formatter
					.parse(request.getParameter("start_date"));
			startDate.setHours(Integer.parseInt(request
					.getParameter("start_date_hour")));
			startDate.setMinutes(Integer.parseInt(request
					.getParameter("start_date_min")));

			Date endDate = formatter.parse(request.getParameter("end_date"));
			endDate.setHours(Integer.parseInt(request
					.getParameter("end_date_hour")));
			endDate.setMinutes(Integer.parseInt(request
					.getParameter("end_date_min")));

			Timestamp start_date = new Timestamp(startDate.getTime());
			Timestamp end_date = new Timestamp(endDate.getTime());

			String description = request.getParameter("description");

			DAOFactory DAOFact = DAOFactory.getDAOFactory();
			EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
			TypeEvenementDAO typeEvenementDAO = DAOFact.getTypeEvenementDAO();
			Evenement event = EvenementDAO.getEvenement(request
					.getParameter("id"));
			event.setTitre(title);
			event.setType(typeEvenementDAO.getTypeEvenement(type));
			event.setDateDebut(start_date);
			event.setDateFin(end_date);
			event.setDescription(description);
			EvenementDAO.updateEvenement(event);
			DAOFact.close();

			request.setAttribute("message", "Événement correctement édité");
			loadHomePage(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "Erreur dans le formatage de la date");
			loadEditPage(request, response);
		}
	}

	private void loadEditPage(HttpServletRequest request,
			HttpServletResponse response) throws DAOConfigureException,
			DAORequestException, ServletException, IOException {
		String id = request.getParameter("id");
		DAOFactory DAOFact = DAOFactory.getDAOFactory();
		EvenementDAO EvenementDAO = DAOFact.getEvenementDAO();
		Evenement event = EvenementDAO.getEvenement(id);
		request.setAttribute("event", event);

		TypeEvenementDAO typeEvenementDAO = DAOFact.getTypeEvenementDAO();
		List<TypeEvenement> typeList = typeEvenementDAO.getTypesEvenements();
		DAOFact.close();
		request.setAttribute("typeList", typeList);


		RequestDispatcher dispacher = getServletContext().getRequestDispatcher(
				"/edit.jsp");
		dispacher.forward(request, response);
	}
}
