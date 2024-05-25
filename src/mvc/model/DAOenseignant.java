package mvc.model;

import Ecole.metier.Enseignant;
import mvc.observer.Subject;

import java.util.List;

public abstract class DAOenseignant extends Subject {

    public abstract Enseignant addEnseignant(Enseignant enseignant);

    public abstract boolean removeEnseignant(Enseignant enseignant);

    public abstract Enseignant updateEnseignant(Enseignant enseignant);

    public abstract Enseignant readEnseignant(int enseignant);

    public abstract List<Enseignant> getEnseignant();
}
