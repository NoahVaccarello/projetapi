package Ecole.metier;

import java.util.Objects;

/**
 * Classe metier de gestion d'une classe d'école
 * @author Noah Vaccarello
 * @version 1.0
 */

public class listeSalleetHeures {

    /**
     *  identifiant de la liste de la salle et l'heure
     */
    protected int idListeSalleetHeures;
    /**
     * salle du cours
     */
    protected Salle salle;
    /**
     * nombre d'heure de cours
     */
    protected int nbreHeures;

    /**
     * constructeur paramétré
     *
     * @param salle      salle du cours
     * @param nbreHeures nombre d'heure de cours
     */

    public listeSalleetHeures(Salle salle, int nbreHeures) {
        this.idListeSalleetHeures = idListeSalleetHeures;
        this.salle = salle;
        this.nbreHeures = nbreHeures;
    }

    /**
     * getter du nombre d'heures
     * @return du nombre d'heures
     */

    public int getNbreHeures() {
        return nbreHeures;
    }

    /**
     * setter du nombre d'heures
     * @param nbreHeures nombre d'heures
     */
    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    /**
     * salle du cours
     * @return salle du cours
     */

    public Salle getSalle() {
        return salle;
    }

    /**
     * salle du cours
     * @param salle salle du cours
     */

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        listeSalleetHeures that = (listeSalleetHeures) o;
        return nbreHeures == that.nbreHeures && Objects.equals(salle, that.salle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salle, nbreHeures);
    }

    @Override
    public String toString() {
        return "listeSalleetHeures{" +
                "salle=" + salle +
                ", nbreHeures=" + nbreHeures +
                '}';
    }
}
