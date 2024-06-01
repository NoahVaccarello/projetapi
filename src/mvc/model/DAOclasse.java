package mvc.model;

import Ecole.metier.*;
import mvc.observer.Subject;

import java.util.List;

public abstract class DAOclasse extends Subject {

    public abstract Classe addClasse(Classe classe);

    public abstract boolean removeClasse(Classe classe);

    public abstract Classe updateClasse(Classe classe);

    public abstract Classe readClasse(int classe);

    public abstract List<Classe> getClasse();

    public abstract int nbrHeuresTot(Classe classe);

    public abstract List<EnseignantEtHeures> enseignantEtHeures(Classe classe);

    public abstract List<ListeCoursEtHeures> coursEtHeures(Classe classe);

    public abstract List<ListeSalleetHeures> salleetHeures(Classe classe);

    public abstract boolean salleCapacitOK(Classe classe);

    public abstract boolean addCours(Classe classe, Cours cours, int nbrheure);

    public abstract boolean modifCours(Classe classe, Cours cours, Salle salle);

    public abstract boolean modifCours(Classe classe, Cours cours, Enseignant enseignant);

    public abstract boolean modifCours(Classe classe, Cours cours, int nbrheure);

    public abstract boolean suppCours(Classe classe, Cours cours);
}
