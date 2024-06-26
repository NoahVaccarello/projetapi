package Ecole.metier;

/**
 * Classe représentant un cours d'une école.
 * @author Noah Vaccarello
 * @version 1.0
 */
public class Cours {

    /**
     * code qui s'incrémente automatiquement
     */
    protected static int id = 1;
    /**
     * id du cours
     */
    protected int id_cours;

    /**
     * Code du cours.
     */
    protected String code;
    /**
     * L'intitulé du cours.
     */
    protected String intitule;

    /**
     * salle du cours
     */
    protected Salle salleParDefaut;

    /**
     * Constructeur paramétré
     * @param code L'identifiant du cours
     * @param intutle L'intitulé du cours
     */

    /*public Cours(String code, String intutle, Salle salleParDefaut) {
        this.id_cours= id++;
        this.code = code;
        this.intutle = intutle;
        this.salleParDefaut = salleParDefaut;
    }*/

    public Cours(int id ,String code, String intutle, Salle salleParDefaut) {
        this.id_cours= id++;
        this.code = code;
        this.intitule = intutle;
        this.salleParDefaut = salleParDefaut;
    }

    public Cours(int id_cours, String code, String intitule) {
        this.id_cours = id_cours;
        this.code = code;
        this.intitule = intitule;
    }


    /**
     * getter code du cours.
     *
     * @return code du cours
     */
    public String getCode() {
        return code;
    }

    /**
     * setter code du cours.
     * @param code identifiant du cours
     */

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * getter intitulé du cours.
     * @return intitulé du cours.
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * setter intitulé du cours.
     * @param intutle intitulé du cours
     */
    public void setIntitule(String intutle) {
        this.intitule = intutle;
    }

    /**
     * getter de la salle
     * @return salle
     */
    public Salle getSalleParDefaut() {
        return salleParDefaut;
    }

    /**
     * setter de la salle
     * @param salleParDefaut salle
     */

    public void setSalleParDefaut(Salle salleParDefaut) {
        this.salleParDefaut = salleParDefaut;
    }

    /**
     * id du cours
     * @return id du cours
     */
    public int getId_cours() {
        return id_cours;
    }

    /**
     * id du cours
     * @param id_cours id du cours
     */
    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id_cours=" + id_cours +
                ", code='" + code + '\'' +
                ", intitule='" + intitule + '\'' +
                ", salleParDefaut=" + salleParDefaut +
                '}';
    }
}
