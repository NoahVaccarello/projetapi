package Ecole;

public class Cours {

    protected int idCours;
    protected String annee;
    protected String intutle;

    public Cours(int idCours, String annee, String intutle) {
        this.idCours = idCours;
        this.annee = annee;
        this.intutle = intutle;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getIntutle() {
        return intutle;
    }

    public void setIntutle(String intutle) {
        this.intutle = intutle;
    }
}
