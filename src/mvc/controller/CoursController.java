package mvc.controller;

import Ecole.metier.Cours;
import mvc.model.DAOcours;
import mvc.view.CoursAbstractView;

import java.util.List;

public class CoursController {
    private DAOcours model;
    private CoursAbstractView view;

    public CoursController(DAOcours model, CoursAbstractView view) {
        this.model = model;
        this.view = view;
    }

    public List<Cours> getAll() {
        return model.getCours();
    }

    public Cours addCours(Cours cours) {
        return model.addCours(cours);
    }

    public boolean removeCours(Cours cours) {
        return model.removeCours(cours);
    }

    public Cours updateCours(Cours cours) {
        return model.updateCours(cours);
    }

    public Cours searchCours(int id_cours) {
        return model.readCours(id_cours);
    }
}

