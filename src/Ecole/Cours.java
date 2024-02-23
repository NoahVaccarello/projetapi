package Ecole;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un cours d'une école.
 * @author Noah Vaccarello
 * @version 1.0
 */
public class Cours {

    /**
     * L'identifiant du cours.
     */
    protected int idCours;

    /**
     * L'année du cours.
     */
    protected String annee;

    /**
     * L'intitulé du cours.
     */
    protected String intutle;

    /**
     * Liste des cours.
     */
    protected List<Cours> listCours = new ArrayList<>();

    /**
     * Constructeur paramétré
     *
     * @param idCours L'identifiant du cours
     * @param annee L'année du cours
     * @param intutle L'intitulé du cours
     */
    public Cours(int idCours, String annee, String intutle) {
        this.idCours = idCours;
        this.annee = annee;
        this.intutle = intutle;
    }

    /**
     * getter identifiant du cours.
     *
     * @return identifiant du cours
     */
    public int getIdCours() {
        return idCours;
    }

    /**
     * setter identifiant du cours.
     *
     * @param idCours identifiant du cours
     */
    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    /**
     * getter année du cours.
     *
     * @return L'année du cours
     */
    public String getAnnee() {
        return annee;
    }

    /**
     * setter année du cours.
     *
     * @param annee année du cours
     */
    public void setAnnee(String annee) {
        this.annee = annee;
    }

    /**
     * getter intitulé du cours.
     * @return intitulé du cours.
     */
    public String getIntutle() {
        return intutle;
    }

    /**
     * setter intitulé du cours.
     * @param intutle intitulé du cours
     */
    public void setIntutle(String intutle) {
        this.intutle = intutle;
    }

    /**
     * getter liste des cours.
     *
     * @return liste des cours
     */
    public List<Cours> getListCours() {
        return listCours;
    }

    /**
     * setter liste des cours.
     *
     * @param listCours La nouvelle liste des cours
     */
    public void setListCours(List<Cours> listCours) {
        this.listCours = listCours;
    }
}
