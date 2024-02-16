package Ecole;

/**
 * Classe d'une gestion d'une classe d'école
 * @author Noah Vaccarello
 * @version 1.0
 */

public class Classe {

    protected int idClasse;
    protected String sigle;
    protected int annee;
    protected String specialite;
    protected int nbreEleves;
    protected Cours cours;

    public Classe(int idClasse, String sigle, int annee, String specialite, int nbreEleves, Cours cours) {
        this.idClasse = idClasse;
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;
        this.cours = cours;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getNbreEleves() {
        return nbreEleves;
    }

    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
