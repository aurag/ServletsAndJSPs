package fr.sigl.imoe.servlet.tp.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet permettant d'initialiser la liste des �v�nements
 * existant dans la base de donn�es.
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
     * Surcharge de la m�thode service qui effectue les traitements ind�pendamment du type de requ�te.
     *
     * @param request               La requ�te HTTP.
     * @param response              La r�ponse HTTP.
     * @throws ServletException     Exception g�n�rique pour le traitement de la servlet.
     * @throws IOException          Exception g�n�rique d'entr�e / sortie.
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO R�cup�ration de la liste des �v�nements disponibles

		// TODO Alimentation de la request avec les informations trouv�es

		// TODO Ajouter le forward vers la page JSP accueil.jsp
    }
}
