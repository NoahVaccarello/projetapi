package mvc.model;

import Ecole.metier.Salle;
import mvc.observer.Subject;

import java.util.List;

public abstract class DAOsalle extends Subject {

    public abstract Salle addSalle(Salle salle);

    public abstract boolean removeSalle(Salle salle);

    public abstract Salle updateSalle(Salle salle);

    public abstract Salle searchSalle(Salle salle);

    public abstract Salle readSalle(int idSalle);

    public abstract List<Salle> getSalle();
}
