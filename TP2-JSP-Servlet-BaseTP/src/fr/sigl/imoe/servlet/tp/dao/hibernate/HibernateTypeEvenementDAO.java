package fr.sigl.imoe.servlet.tp.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

import fr.sigl.imoe.servlet.tp.bo.TypeEvenement;
import fr.sigl.imoe.servlet.tp.dao.TypeEvenementDAO;
import fr.sigl.imoe.servlet.tp.dao.exceptions.DAORequestException;

/**
 * Implémentation Hibernate de TypeEvenementDAO.
 *
 * @author Chris
 */
public class HibernateTypeEvenementDAO implements TypeEvenementDAO {
    /**
     * Logger JUL.
     */
    public static final Logger LOGGER = Logger.getLogger(HibernateTypeEvenementDAO.class.getName());
    /**
     * Instance de la HibernateDAOFactory.
     */
    private HibernateDAOFactory factory;

    /**
     * Constructeur é partir d'une factory.
     *
     * @param newFactory           Instance de HibernateDAOFactory
     */
    public HibernateTypeEvenementDAO(HibernateDAOFactory newFactory) {
        super();
        this.factory = newFactory;
    }

    /**
     * Retourne la liste des types d'événements.
     *
     * @return La liste des types d'événements existantes.
     * @exception  DAORequestException      Exception générique lors de l'accés à la base.
     * @see fr.sigl.imoe.servlet.tp.dao.TypeEvenementDAO#getTypesEvenements()
     */
    @SuppressWarnings("unchecked")
	public List<TypeEvenement> getTypesEvenements() throws DAORequestException {
        List<TypeEvenement> lstTypesEvenements = new ArrayList<TypeEvenement>();
        Session session = null;
        try {
            // Exécution de la requète.
            session = factory.getSession();
            lstTypesEvenements = session.getNamedQuery("typeEvenement.list").list();
        } catch (Exception e) {
            String errMsg = "Erreur lors de la récupération de la liste des types.";
            LOGGER.log(Level.SEVERE, errMsg, e);
            throw new DAORequestException(errMsg, e);
        }
        return lstTypesEvenements;
    }

    /**
     * Retourne le type d'événement associée à l'id spécifié en paramétre.
     *
     * @param  id                           L'identifiant technique du type.
     * @return L'instance du type d'événement correspondant à l'identifiant technique.
     * @exception  DAORequestException      Exception générique lors de l'accés à la base.
     * @see fr.sigl.imoe.servlet.tp.dao.TypeEvenementDAO#getTypeEvenement(java.lang.String)
     */
    public TypeEvenement getTypeEvenement(String id) throws DAORequestException {
        // Vérification préalable
        if (id == null) {
            throw new DAORequestException("L'identifiant du type ne doit pas étre null pour une recherche.");
        }

        TypeEvenement typeEvenement = null;
        Session session = null;
        try {
            // Exécution de la requète.
            session = factory.getSession();
            typeEvenement = (TypeEvenement) session.get(TypeEvenement.class, id);
        } catch (Exception e) {
            String errMsg = "Erreur lors de la récupération du type ayant pour identifiant '" + id + "'";
            LOGGER.log(Level.SEVERE, errMsg, e);
            throw new DAORequestException(errMsg, e);
        }
        return typeEvenement;
    }
}
