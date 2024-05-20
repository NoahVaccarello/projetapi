package mvc.controller;

import Ecole.metier.Classe;
import mvc.model.DAOclasse;
import mvc.view.ClasseAbstractView;


import java.util.List;

public class ClasseController {
    private DAOclasse model;
    private ClasseAbstractView view;

    public ClasseController(DAOclasse model, ClasseAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Classe> getAll(){
        return model.getClasse();
    }
    public Classe addClasse(Classe client) {
        return  model.addClasse(client);
    }

    public boolean remove(Classe classe) {
        return model.removeClasse(classe);
    }

    public Classe updateClasse(Classe classe) {
        return model.updateClasse(classe);
    }

    public Classe search(int id_classe ) {
        return model.readClasse(id_classe);
    }
}

