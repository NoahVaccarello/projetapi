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

    private DAOsalle sm;
    private DAOcours com;
    private DAOclasse cm;
    private DAOenseignant em;


    private CoursController coc;
    private SalleController sc;
    private ClasseController cc;
    private EnseignantController ec;


    private CoursAbstractView cov;
    private SalleAbstractView sv;
    private ClasseAbstractView cv;
    private EnseignantAbstractView ev;

    public void gestion() {


        sv = new SalleViewConsole();
        sm = new ModelSalleDB();
        sc = new SalleController(sm, sv);


        cov = new CoursViewConsole(sc);
        com = new ModelCoursDB(sc);
        coc = new CoursController(com, cov);


        cv = new ClasseViewConsole();
        cm = new ModelClasseDB();
        cc = new ClasseController(cm, cv);


        ev = new EnseignantViewConsole();
        em = new ModelEnseignantDB();
        ec = new EnseignantController(em, ev);


        cv.setSalleView(sv);
        cv.setCoursView(cov);
        cv.setEnseignantView(ev);


        em.addObserver(ev);
        com.addObserver(cov);
        cm.addObserver(cv);
        sm.addObserver(sv);

        List<String> loptions = Arrays.asList("salles", "cours", "classes", "enseignants", "fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch) {
                case 1:
                    sv.menu();
                    break;
                case 2:
                    cov.menu();
                    break;
                case 3:
                    cv.menu();
                    break;
                case 4:
                    ev.menu();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }

    public static void main(String[] args) {
        GestEcole gestEcole = new GestEcole();
        gestEcole.gestion();
    }

}
