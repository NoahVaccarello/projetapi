package mvc.controller;

import Ecole.metier.Enseignant;
import mvc.model.DAOenseignant;
import mvc.view.EnseignantAbstractView;

import java.util.List;

public class EnseignantController {

    private DAOenseignant model;
    private EnseignantAbstractView view;

    public EnseignantController(DAOenseignant model, EnseignantAbstractView view) {
        this.model = model;
        this.view = view;
    }

    public List<Enseignant> getAllEnseignant() {
        return model.getEnseignant();
    }

    public Enseignant addEnseignant(Enseignant cours) {
        return model.addEnseignant(cours);
    }

    public boolean removeEnseignant(Enseignant cours) {
        return model.removeEnseignant(cours);
    }

    public Enseignant updateEnseignant(Enseignant cours) {
        return model.updateEnseignant(cours);
    }

    public Enseignant searchEnseignant(int id_cours) {
        return model.readEnseignant(id_cours);
    }


}
