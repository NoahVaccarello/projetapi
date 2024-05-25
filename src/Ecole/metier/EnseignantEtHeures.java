package Ecole.metier;

/**
 * Classe metier de gestion d'une classe d'école
 * @author Noah Vaccarello
 * @version 1.0
 */

public class EnseignantEtHeures {

    /**
     * L'enseignant associé
     */

    protected Enseignant enseignant;
    /**
     * nombre d'heures attribuées à cet enseignant
     */
    protected int heures;


    /**
     * Constructeur paramétré.
     * @param enseignant L'enseignant associé
     * @param heures Le nombre d'heures attribuées à cet enseignant
     */
    public EnseignantEtHeures(Enseignant enseignant, int heures) {
        this.enseignant = enseignant;
        this.heures = heures;
    }

    /**
     * Getter pour le nombre d'heures attribuées à l'enseignant.
     * @return Le nombre d'heures attribuées à l'enseignant
     */
    public int getHeures() {
        return heures;
    }

    /**
     * Setter pour le nombre d'heures attribuées à l'enseignant.
     * @param heures Le nombre d'heures attribuées à l'enseignant
     */
    public void setHeures(int heures) {
        this.heures = heures;
    }
}
