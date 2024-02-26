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
    protected String idCours;
    /**
     * L'intitulé du cours.
     */
    protected String intutle;

    /**
     * salle du cours
     */
    protected Salle salleParDefaut;

    /**
     * Constructeur paramétré
     *
     * @param idCours L'identifiant du cours
     * @param intutle L'intitulé du cours
     */

    public Cours(String idCours, String intutle, Salle salleParDefaut) {
        this.idCours = idCours;
        this.intutle = intutle;
        this.salleParDefaut = salleParDefaut;
    }

    /**
     * getter identifiant du cours.
     *
     * @return identifiant du cours
     */
    public String getIdCours() {
        return idCours;
    }

    /**
     * setter identifiant du cours.
     * @param idCours identifiant du cours
     */

    public void setIdCours(String idCours) {
        this.idCours = idCours;
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
     * getter de la salle
     * @return salle
     */
    public Salle getSalle() {
        return salleParDefaut;
    }

    /**
     * setter de la salle
     * @param salleParDefaut salle
     */

    public void setSalle(Salle salleParDefaut) {
        this.salleParDefaut = salleParDefaut;
    }
}
