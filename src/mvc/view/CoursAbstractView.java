package mvc.view;

import Ecole.metier.Cours;
import mvc.controller.CoursController;
import mvc.observer.Observer;

import java.util.List;

public abstract class CoursAbstractView implements Observer {

    protected CoursController coursController;
    protected List<Cours> co;

    public void setController(CoursController coursController) {
        this.coursController = coursController;
    }

    public abstract void affMsg(String msg);

    public abstract Cours selectionner();

    public abstract void menu();

    public abstract void affListC(List co);

    @Override
    public void update(List co) {
        this.co = co;
        affListC(co);
    }

}
