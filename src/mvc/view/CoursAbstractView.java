package mvc.view;

import Ecole.metier.Cours;
import mvc.controller.CoursController;
import mvc.observer.Observer;

import java.util.List;

public abstract class CoursAbstractView implements Observer {

    protected CoursController classeController;
    protected List<Cours> cl;

    public void  setController(CoursController classeController){
        this.classeController=classeController;
    }
    public abstract void affMsg(String msg);

    public abstract Cours selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List cl) {
        this.cl = cl;
        affList(cl);
    }

}
