package mvc.controller;


import Ecole.metier.Salle;
import mvc.model.DAOsalle;
import mvc.view.SalleAbstractView;

import java.util.List;

public class SalleController {
    private DAOsalle model;
    private SalleAbstractView view;

    public SalleController(DAOsalle model, SalleAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Salle> getAllSalle(){
        return model.getSalles();
    }
    public Salle addSalle(Salle salle) {
        return  model.addSalle(salle);
    }

    public boolean removeSalle(Salle salle) {
        return model.removeSalle(salle);
    }

    public Salle updateSalle(Salle salle) {
        return model.updateSalle(salle);
    }

    public Salle searchSalle(int idSalle) {
        return model.readSalle(idSalle);
    }
}
