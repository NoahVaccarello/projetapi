package mvc.model;

import Ecole.metier.Classe;
import mvc.observer.Subject;

import java.util.List;

public abstract class DAOclasse extends Subject {
    public abstract Classe addClasse(Classe classe);

    public abstract boolean removeClasse(Classe classe);

    public abstract Classe updateClasse(Classe classe);

    public abstract Classe readClasse(int classe);

    public abstract List<Classe> getClasse();
}
