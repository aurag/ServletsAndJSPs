package fr.sigl.imoe.servlet.tp.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet permettant d'initialiser la liste des événements
 * existant dans la base de données.
 */
@WebServlet(
        name = "ListingServlet",
        urlPatterns = {"/listing"}
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
		// TODO Récupération de la liste des événements disponibles

		// TODO Alimentation de la request avec les informations trouvées

		// TODO Ajouter le forward vers la page JSP accueil.jsp
    }
}
