package Ecole;

public class EnseignantEtHeures {

    protected Enseignant enseignant;
    protected int heures;

    public EnseignantEtHeures(Enseignant enseignant, int heures) {
        this.enseignant = enseignant;
        this.heures = heures;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }
}
