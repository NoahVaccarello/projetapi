package Ecole;

import Ecole.Classe;
import Ecole.Cours;
import Ecole.Enseignant;

import java.util.ArrayList;
import java.util.List;

public class Infos {

    protected int idInfo;
    protected int nbreHeures;
    protected List<Ecole.Cours> Cours = new ArrayList<>();
    protected List<Ecole.Classe> Classe = new ArrayList<>();
    protected Enseignant enseignant;
    protected Salle sale;

    public Infos(int idInfo, int nbreHeures, List<Ecole.Cours> cours, List<Ecole.Classe> classe, Enseignant enseignant, Salle sale) {
        this.idInfo = idInfo;
        this.nbreHeures = nbreHeures;
        Cours = cours;
        Classe = classe;
        this.enseignant = enseignant;
        this.sale = sale;
    }

    public int getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public List<Ecole.Cours> getCours() {
        return Cours;
    }

    public void setCours(List<Ecole.Cours> cours) {
        Cours = cours;
    }

    public List<Ecole.Classe> getClasse() {
        return Classe;
    }

    public void setClasse(List<Ecole.Classe> classe) {
        Classe = classe;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Salle getSale() {
        return sale;
    }

    public void setSale(Salle sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Infos{" +
                "idInfo=" + idInfo +
                ", nbreHeures=" + nbreHeures +
                ", Cours=" + Cours +
                ", Classe=" + Classe +
                ", enseignant=" + enseignant +
                ", sale=" + sale +
                '}';
    }
}
