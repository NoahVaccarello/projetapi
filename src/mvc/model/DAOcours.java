package mvc.model;

import Ecole.metier.Cours;
import mvc.observer.Subject;

import java.util.List;

public abstract class DAOcours extends Subject {
    public abstract Cours addCours(Cours cours);

    public abstract boolean removeCours(Cours cours);

    public abstract Cours updateCours(Cours cours);

    public abstract Cours readCours(int id_cours);

    public abstract List<Cours> getCours();
}
