package designpatterns.builder;

public class EnseignantsHeures {
    private Enseignant enseignant;
    private int nbreHeures;

    public EnseignantsHeures(Enseignant enseignant, int nbreHeures) {
        this.enseignant = enseignant;
        this.nbreHeures = nbreHeures;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }
}
