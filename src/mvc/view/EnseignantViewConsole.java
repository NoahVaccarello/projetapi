package mvc.view;

import Ecole.metier.Enseignant;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static utilitaires.Utilitaire.*;

public class EnseignantViewConsole extends EnseignantAbstractView{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void affList(List infos) {
        affListe(infos);
    }

    @Override
    public void menu() {
        update(enseignantController.getAll());
        do {

            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "fin"));
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

    private void modifier() {
        int nl = choixListe(en);
        Enseignant enseignant = en.get(nl);
        String matricule= modifyIfNotBlank("numéro du matricule",enseignant.getMatricule());
        String nom = modifyIfNotBlank("nom", enseignant.getNom());
        String prenom = modifyIfNotBlank("prenom", enseignant.getPrenom());
        String tel = modifyIfNotBlank("tel", enseignant.getTel());
        int chargeSem = parseInt(modifyIfNotBlank("chargesem","" + enseignant.getChargeSem()));
        double salaireMensu = Double.parseDouble(modifyIfNotBlank("chargesem","" + enseignant.getChargeSem()));
        String date = modifyIfNotBlank("date d'engagement :", enseignant.getDateEngag() + "");
        LocalDate dateengag = !date.equals("null")?LocalDate.parse(date):null;
        Enseignant ens =enseignantController.updateEnseignant(new Enseignant(enseignant.getIdEnseignant(), matricule, nom, prenom, tel, chargeSem, salaireMensu, dateengag));
        if(ens==null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+ens);
    }

    private void rechercher() {
        System.out.println("id de l'enseignant : ");
        int id_enseignant = sc.nextInt();
        Enseignant ens = enseignantController.searchEnseignant(id_enseignant);
        if(ens==null) affMsg("recherche infructueuse");
        else {

            affMsg(ens.toString());
        }
    }

    private void retirer() {

        int nl = choixElt(en)-1;
        Enseignant enseignant = en.get(nl);
        boolean ok = enseignantController.removeEnseignant(enseignant);
        if(ok) affMsg("enseignant effacé");
        else affMsg("ensaignent non effacé");
    }

    private void ajouter() {
        System.out.print("matricule : ");
        String matricule = sc.nextLine();
        System.out.print("nom : ");
        String nom = sc.nextLine();
        System.out.print("prenom : ");
        String prenom = sc.nextLine();
        System.out.print("tel : ");
        String tel = sc.nextLine();
        System.out.print("chargesem : ");
        int chargesem = Integer.parseInt(sc.nextLine());
        System.out.print("salaire mensu : ");
        double salairemensu = Double.parseDouble(sc.nextLine());
        // pour que la date sois plus facile a rentrer j'ai trouver cette façon de faire sur internet
        System.out.print("Jour de la date d'engagement : ");
        int jour = Integer.parseInt(sc.nextLine());
        System.out.print("Mois de la date d'engagement : ");
        int mois = Integer.parseInt(sc.nextLine());
        System.out.print("Année de la date d'engagement : ");
        int annee = Integer.parseInt(sc.nextLine());

        LocalDate datee = LocalDate.of(annee, mois, jour);

        Enseignant enseignant = enseignantController.addEnseignant(new Enseignant(0, matricule, nom, prenom, tel, chargesem, salairemensu, datee));
        if (enseignant != null) {
            affMsg("Création de : " + enseignant);
        } else {
            affMsg("Erreur de création"); // le message d'erreur s'affiche alors que l'enseignant a bien ete ajouter
        }
    }


    @Override
    public Enseignant selectionner() {
        update(enseignantController.getAll());
        int nl = choixListe(en);
        Enseignant ens = en.get(nl - 1);
        return ens;
    }
}

