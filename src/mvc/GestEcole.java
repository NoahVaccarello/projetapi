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
    private DAOclasse clm;
    private DAOcours com;
    private DAOenseignant em;
    private DAOsalle sm;
    private ClasseController cc;
    private CoursController coc;
    private EnseignantController ec;
    private SalleController sc;
    private ClasseAbstractView cv;
    private CoursAbstractView cov;
    private EnseignantAbstractView ev;
    private SalleAbstractView sv;

    public void gestion() {
        // Initialisation des modèles
        clm = new ModelClasseDB();
        sm = new ModelSalleDB();  // Initialisation de DAO salle

        // Passe DAOsalle à ModelCoursDB
        com = new ModelCoursDB(sm);

        em = new ModelEnseignantDB();

        // Initialisation des vues
        cv = new ClasseViewConsole();
        cov = new CoursViewConsole();
        ev = new EnseignantViewConsole();
        sv = new SalleViewConsole();

        // Initialisation des contrôleurs
        cc = new ClasseController(clm, cv);  // création et injection de dépendance
        coc = new CoursController(com, cov);
        ec = new EnseignantController(em, ev);
        sc = new SalleController(sm, sv);

        // Ajout des observateurs
        clm.addObserver(cv);
        com.addObserver(cov);
        em.addObserver(ev);
        sm.addObserver(sv);

        // Menu principal
        List<String> loptions = Arrays.asList("classe", "cours", "enseignant", "salle", "fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch) {
                case 1:
                    cv.menu();
                    break;
                case 2:
                    cov.menu();
                    break;
                case 3:
                    ev.menu();
                    break;
                case 4:
                    sv.menu();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }

    public static void main(String[] args) {
        GestEcole ge = new GestEcole();
        ge.gestion();
    }
}
