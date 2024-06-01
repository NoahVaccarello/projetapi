package mvc.controller;

import Ecole.metier.*;
import mvc.model.DAOclasse;
import mvc.model.DAOenseignant;
import mvc.view.ClasseAbstractView;
import mvc.view.EnseignantAbstractView;

import java.util.List;

public class EnseignantController {
    private DAOenseignant model;
    private EnseignantAbstractView view;

    public EnseignantController(DAOenseignant model, EnseignantAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Enseignant> getAll() {
        return model.getEnseignant();
    }

    public Enseignant addEnseignant(Enseignant enseignant) {
        return model.addEnseignant(enseignant);
    }

    public boolean removeEnseignant(Enseignant enseignant) {
        return model.removeEnseignant(enseignant);
    }

    public Enseignant updateEnseignant(Enseignant enseignant) {
        return model.updateEnseignant(enseignant);
    }

    public Enseignant searchEnseignant(int id_enseignant) {
        return model.readEnseignant(id_enseignant);
    }

}

