package Ecole;

import java.math.BigDecimal;
import java.util.Date;

public class Enseignant {

    protected int idEnseignant;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected String tel;
    protected int chargeSem;
    protected Date dateEngag;
    protected BigDecimal annee;

    public Enseignant(int idEnseignant, String matricule, String nom, String prenom, String tel, int chargeSem, Date dateEngag, BigDecimal annee) {
        this.idEnseignant = idEnseignant;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.dateEngag = dateEngag;
        this.annee = annee;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getChargeSem() {
        return chargeSem;
    }

    public void setChargeSem(int chargeSem) {
        this.chargeSem = chargeSem;
    }

    public Date getDateEngag() {
        return dateEngag;
    }

    public void setDateEngag(Date dateEngag) {
        this.dateEngag = dateEngag;
    }

    public BigDecimal getAnnee() {
        return annee;
    }

    public void setAnnee(BigDecimal annee) {
        this.annee = annee;
    }
}