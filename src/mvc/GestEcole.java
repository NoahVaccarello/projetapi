package mvc;

import mvc.controller.ClasseController;
import mvc.controller.CoursController;
import mvc.controller.EnseignantController;
import mvc.controller.SalleController;
import mvc.model.*;
import mvc.view.*;
import utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestEcole {

    public DAOsalle daoSalle;
    public static DAOcours daoCours;
    public DAOclasse daoClasse;
    public DAOenseignant daoEnseignant;

    public CoursController coursController;
    public SalleController salleController;
    public ClasseController classeController;
    public EnseignantController enseignantController;

    public CoursAbstractView coursView;
    public SalleAbstractView salleView;
    public ClasseAbstractView classeView;
    public EnseignantAbstractView enseignantView;

    public void gestion() {
        salleView = new SalleViewConsole();
        daoSalle = new ModelSalleDB();
        salleController = new SalleController(daoSalle, salleView);

        coursView = new CoursViewConsole(salleController);
        daoCours = new ModelCoursDB(salleController);
        coursController = new CoursController(daoCours, coursView);

        classeView = new ClasseViewConsole();
        daoClasse = new ModelClasseDB();
        classeController = new ClasseController(daoClasse, classeView);

        enseignantView = new EnseignantViewConsole();
        daoEnseignant = new ModelEnseignantDB();
        enseignantController = new EnseignantController(daoEnseignant, enseignantView);

        classeView.setSalleView(salleView);
        classeView.setCoursView(coursView);
        classeView.setEnseignantView(enseignantView);

        daoEnseignant.addObserver(enseignantView);
        daoCours.addObserver(coursView);
        daoClasse.addObserver(classeView);
        daoSalle.addObserver(salleView);

        List<String> optionsMenu = Arrays.asList("Gestion des salles", "Gestion des cours", "Gestion des classes", "Gestion des enseignants", "Fin");
        do {
            int choix = Utilitaire.choixListe(optionsMenu);
            switch (choix) {
                case 1:
                    salleView.menu();
                    break;
                case 2:
                    coursView.menu();
                    break;
                case 3:
                    classeView.menu();
                    break;
                case 4:
                    enseignantView.menu();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }

    public static void main(String[] args) {
        GestEcole gestionEcole = new GestEcole();
        gestionEcole.gestion();
    }

}
