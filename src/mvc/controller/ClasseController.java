package mvc.controller;

import Ecole.metier.*;
import mvc.model.DAOclasse;
import mvc.view.ClasseAbstractView;

import java.util.List;

public class ClasseController {
    private DAOclasse model;
    private ClasseAbstractView view;

    public ClasseController(DAOclasse model, ClasseAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Classe> getAll() {
        return model.getClasse();
    }

    public Classe addClasse(Classe classe) {
        return model.addClasse(classe);
    }

    public boolean removeClasse(Classe classe) {
        return model.removeClasse(classe);
    }

    public Classe updateClasse(Classe classe) {
        return model.updateClasse(classe);
    }

    public Classe searchClasse(int id_classe) {
        return model.readClasse(id_classe);
    }

    public int nbrHeuresTot(Classe classe) {

        return model.nbrHeuresTot(classe);
    }

    public List<EnseignantEtHeures> listEnseignantEtHeures(Classe classe) {
        return model.enseignantEtHeures(classe);
    }


    public List<ListeCoursEtHeures> listCoursEtHeures(Classe classe) {
        return model.coursEtHeures(classe);
    }

    public List<ListeSalleetHeures> listSalleetHeures(Classe classe) {
        return model.salleetHeures(classe);
    }

    public boolean salleCapacitOK(Classe classe) {
        return model.salleCapacitOK(classe);
    }

    public boolean addCours(Salle salle,Classe classe, Cours cours, int nbrheure,Enseignant enseignant) {
        return model.addCours(salle,classe, cours, nbrheure,enseignant);
    }

    public boolean modifCours(Classe classe, Cours cours, Salle salle) {
        return model.modifCours(classe, cours, salle);
    }

    public boolean modifCours(Classe classe, Cours cours, Enseignant enseignant) {
        return model.modifCours(classe, cours, enseignant);
    }


    public boolean modifCours(Classe classe, Cours cours, int nbrheure) {
        return model.modifCours(classe, cours, nbrheure);
    }

    public boolean suppCours(Classe classe, Cours cours) {
        return model.suppCours(classe, cours);
    }

}

