package mvc.view;

import Ecole.metier.Classe;
import mvc.controller.ClasseController;
import mvc.observer.Observer;

import java.util.List;

public abstract class ClasseAbstractView implements Observer {

    protected ClasseController classeController;
    protected SalleAbstractView salleA;
    protected CoursAbstractView coursA;
    protected EnseignantAbstractView enseignantA;
    protected List<Classe> cl;

    public void setController(ClasseController classeController){
        this.classeController=classeController;
    }

    public void setSalleView(SalleAbstractView salleA) {
        this.salleA = salleA;
    }

    public void setCoursView(CoursAbstractView coursA) {
        this.coursA = coursA;
    }

    public void setEnseignantView(EnseignantAbstractView enseignantA) {
        this.enseignantA = enseignantA;
    }

    public abstract void affMsg(String msg);

    public abstract Classe selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List cl) {
        this.cl = cl;
        affList(cl);
    }

}
