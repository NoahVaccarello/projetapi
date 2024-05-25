package Ecole.metier;

import java.util.Objects;

/**
 * Classe metier de gestion d'une classe d'école
 * @author Noah Vaccarello
 * @version 1.0
 */

public class ListeCoursEtHeures {

    /**
     *  Cours d'une classe
     */
    protected Cours cours;
    /**
     * nombre d'heure d'un cours
     */
    protected int nbreHeures;

    /**
     * Constructeur paramétré.
     * @param cours Le cours associé
     * @param nbreHeures Le nombre d'heures pour ce cours
     */
    public ListeCoursEtHeures(Cours cours, int nbreHeures) {
        this.cours = cours;
        this.nbreHeures = nbreHeures;
    }
    /**
     * Getter pour le cours associé.
     * @return Le cours associé
     */

    public Cours getCours() {
        return cours;
    }
    /**
     * Setter pour le cours associé.
     * @param cours Le cours associé
     */

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    /**
     * Getter pour le nombre d'heures.
     * @return Le nombre d'heures pour ce cours
     */
    public int getNbreHeures() {
        return nbreHeures;
    }
    /**
     * Setter pour le nombre d'heures.
     * @param nbreHeures Le nombre d'heures pour ce cours
     */

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListeCoursEtHeures that = (ListeCoursEtHeures) o;
        return nbreHeures == that.nbreHeures && Objects.equals(cours, that.cours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cours, nbreHeures);
    }
}
