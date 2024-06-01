package mvc.view;

import Ecole.metier.*;
import mvc.model.DAOsalle;
import utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class ClasseViewConsole extends ClasseAbstractView {
    private Scanner sc = new Scanner(System.in);

    protected SalleViewConsole salleA;
    protected CoursViewConsole coursA;
    protected EnseignantViewConsole enseignantA;
    private DAOsalle daosalle;

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void affList(List infos) {
        affListe(infos);
    }


    public void menu() {
        update(classeController.getAll());
        do {
            int ch = choixListe(Arrays.asList("ajouter une classe", "retirer une classe", "rechercher une classe", "modifier une classe", "fin"));

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void special(Classe cl) {
        do {

            int ch = choixListe(Arrays.asList("ajouter cours", "nombre heure", "modifier cours et heure", "modifierCoursSalle","supprimerCours","listerCours","listerEnsHeure","listerCoursHeure","ListerSalleHeure", "menu principal"));

            switch (ch) {
                case 1:
                    ajouterCours(cl);
                    break;
                case 2:
                    nbrHeuretot(cl);
                    break;
                case 3:
                    modifierCoursHeure(cl);
                    break;
                case 4:
                    modifierCoursSalle(cl);
                    break;
                case 5:
                    modifierCoursEnseignant(cl);
                    break;
                case 6:
                    supprimerCours(cl);
                    break;
                case 7:
                    listerCours(cl);
                    break;
                case 8:
                    listEnseignantEtHeures(cl);
                    break;
                case 9:
                    listCoursEtHeures(cl);
                    break;
                case 10:
                    listSalleetHeures(cl);
                    break;
                case 11:
                    return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);

    }


    private void modifier() {
        int nl = choixElt(cl);
        Classe cla = cl.get(nl - 1);
        String sigle = modifyIfNotBlank("numéro du sigle", cla.getSigle());
        int annee = Integer.parseInt(modifyIfNotBlank("Annee de cours", "" + cla.getAnnee()));
        String specialite = modifyIfNotBlank("Specialite : ", cla.getSpecialite());
        int nbreEleves = Integer.parseInt(modifyIfNotBlank("Nombre d'élvève ", "" + cla.getNbreEleves()));
        Classe clamaj = classeController.updateClasse(new Classe(cla.getIdClasse(), sigle, annee, specialite, nbreEleves));
        if (clamaj == null) affMsg("mise à jour infrucueuse");
        else affMsg("mise à jour effectuée : " + clamaj);
    }

    /*private void modifier() {
        int nl = Utilitaire.choixElt(this.cl) - 1;
        Classe classe = (Classe)this.cl.get(nl);
        String sigle = Utilitaire.modifyIfNotBlank("sigle", classe.getSigle());
        int annee = Integer.parseInt(Utilitaire.modifyIfNotBlank("annee", "" + classe.getAnnee()));
        String specialite = Utilitaire.modifyIfNotBlank("specialite", classe.getSpecialite());
        int nbreeleves = Integer.parseInt(Utilitaire.modifyIfNotBlank("nombre d'eleve", "" + classe.getNbreEleves()));
        Classe cl = this.classeController.updateClasse(new Classe(classe.getIdClasse(), sigle, annee, specialite, nbreeleves));
        if (cl == null) {
            this.affMsg("mise à jour infructueuse");
        } else {
            this.affMsg("mise à jour effectuée : " + String.valueOf(cl));
        }

    }*/

    private void rechercher() {
        System.out.println("id de la classe : ");
        int id_classe = sc.nextInt();
        Classe cl = classeController.searchClasse(id_classe);
        if (cl == null) affMsg("recherche infructueuse");
        else {

            affMsg(cl.toString());
            special(cl);
        }

    }

    private void retirer() {

        int nl = choixElt(cl);
        Classe cla = cl.get(nl - 1);
        boolean ok = classeController.removeClasse(cla);
        if (ok) affMsg("classe effacé");
        else affMsg("classe non effacé");
    }

    private void ajouter() {
        System.out.print("numéro du sigle : ");
        String sigle = sc.next();
        System.out.print("Année : ");
        int annee = sc.nextInt();
        System.out.print("Specialité :");
        String specialite = sc.next();
        System.out.print("Nombre d'élève : ");
        int nbreEleves = Integer.parseInt(sc.next());
        Classe cla = classeController.addClasse(new Classe(0,sigle, annee, specialite, nbreEleves));
        if (cla != null) affMsg("création de :" + cla);
        else affMsg("erreur de création");
    }

    @Override
    public Classe selectionner() {
        update(classeController.getAll());
        int nl = choixListe(cl);
        Classe cla = cl.get(nl - 1);
        return cla;
    }

    private void nbrHeuretot(Classe cl) {
        int heuretot = classeController.nbrHeuresTot(cl);
        affMsg("heuretot: " + heuretot);
    }

    public void salleCapaciteOK(Salle salle) {

        //todo

    }

    public void ajouterCours(Classe cl) {

        System.out.println("Ajouter un cours");
        Cours cr = coursA.selectionner();
        System.out.println("Nombre d'heure du cours : ");
        int heure = sc.nextInt();
        boolean ok = classeController.addCours(cl, cr, heure);
        if (ok) affMsg("Cours ajouté avec succes");
        else affMsg("erreur lors de l'ajout du cours");
    }

    public void modifierCoursHeure(Classe cl) {
        System.out.println("Modifier un cours");
        Cours cr = coursA.selectionner();
        System.out.println("Nombre d'heure du cours : ");
        int heure = sc.nextInt();
        boolean ok = classeController.modifCours(cl, cr, heure);
        if (ok) affMsg("Mise a jour réussie");
        else affMsg("erreur lors de la mise a jour du cours");

    }

    public void modifierCoursSalle(Classe cl) {
        System.out.println("Modifier un cours");
        Cours cr = coursA.selectionner();
        System.out.println("Numero de la salle : ");
        Salle salle = salleA.selectionner();
        boolean ok = classeController.modifCours(cl, cr, salle);
        if (ok) affMsg("Mise a jour réussie");
        else affMsg("erreur lors de la mise a jour du cours");

    }

    public void modifierCoursEnseignant(Classe cl) {
        System.out.println("Modifier un cours");
        Cours cr = coursA.selectionner();
        System.out.println("Ensiegnant : ");
        Enseignant nom = enseignantA.selectionner();
        boolean ok = classeController.modifCours(cl, cr, nom);
        if (ok) affMsg("Mise a jour réussie");
        else affMsg("erreur lors de la mise a jour du cours");

    }

    private void supprimerCours(Classe cl) {
        System.out.println("suppression d'un cours");
        Cours cr = coursA.selectionner();
        boolean ok = classeController.suppCours(cl, cr);
        if (ok) affMsg("cours supprimée");
        else affMsg("cours non supprimée");
    }

    private void listerCours(Classe cl) {
        System.out.println("pCours");
        List<Infos> listinfo = classeController.getCours(cl);
        if(listinfo.isEmpty()) affMsg("aucune ligne pour cette commmande");
        else affList(listinfo);
    }

    public void listEnseignantEtHeures(Classe cl) {
        List<EnseignantEtHeures> listEH = classeController.listEnseignantEtHeures(cl);
        if (listEH.isEmpty()) {
            System.out.println("La liste est vide");
        } else {
            System.out.println(listEH);
        }
    }

    public void listCoursEtHeures(Classe cl) {
        List<ListeCoursEtHeures> listCH = classeController.listCoursEtHeures(cl);
        if (listCH.isEmpty()) {
            System.out.println("La liste est vide");
        }
        else {
            affList(listCH);
        }
    }

    public void listSalleetHeures(Classe cl) {
        List<ListeSalleetHeures> listSH = classeController.listSalleetHeures(cl);
        if (listSH.isEmpty()) {
            System.out.println("La liste est vide");
        }
        else {
            affList(listSH);
        }
    }



}

