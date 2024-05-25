package mvc.model;

import mvc.observer.Subject;
import Ecole.metier.Salle;

import java.util.List;

public abstract class DAOsalle extends Subject {
    public abstract Salle addSalle(Salle salle);

    public abstract boolean removeSalle(Salle salle);

    public abstract Salle updateSalle(Salle salle);

    public static Salle readSalle(int id_salle) {
        return null;
    }

    public abstract List<Salle> getSalles();
}
