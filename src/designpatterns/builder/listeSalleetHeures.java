package designpatterns.builder;

public class listeSalleetHeures {

    protected Salle salle;
    protected int nbreHeures;

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public listeSalleetHeures(Salle salle, int nbreHeures) {
        this.salle = salle;
        this.nbreHeures = nbreHeures;
    }

    public listeSalleetHeures() {}
}
