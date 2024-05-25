package mvc.view;

import Ecole.metier.Enseignant;
import mvc.controller.EnseignantController;
import mvc.observer.Observer;

import java.util.List;

public abstract class EnseignantAbstractView  implements Observer {
    protected EnseignantController enseignantController;
    protected List<Enseignant> cl;
    public void setController(EnseignantController enseignantController){
        this.enseignantController = enseignantController;
    }

    public abstract void affMsg(String msg);
    public abstract Enseignant selectionner();

    public abstract void menu();
    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.cl = lc;
        affList(lc);
    }

}
