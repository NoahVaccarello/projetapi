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

    @Override
    public void affList(List l) {

    }

    private void modifier() {
        int nl = choixElt(cl);
        Enseignant enseignant = cl.get(nl);
        String matricule= modifyIfNotBlank("numéro du matricule",enseignant.getMatricule());
        String nom = modifyIfNotBlank("nom", enseignant.getNom());
        String prenom = modifyIfNotBlank("prenom", enseignant.getPrenom());
        String tel = modifyIfNotBlank("tel", enseignant.getTel());
        int chargeSem = parseInt(modifyIfNotBlank("chargesem","" + enseignant.getChargeSem()));
        double salaireMensu = Double.parseDouble(modifyIfNotBlank("chargesem","" + enseignant.getChargeSem()));
        String date = modifyIfNotBlank("date de fin :", enseignant.getDateEngag() + "");
        LocalDate dateengag = !date.equals("null") ? LocalDate.parse(date) : null;
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

        int nl = choixElt(cl);
        Enseignant enseignant = cl.get(nl-1);
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
        int chargesem = parseInt(sc.nextLine());
        System.out.print("salaire mensu : ");
        double salairemensu = Double.parseDouble(sc.nextLine());
        System.out.print("Date : ");
        String date = sc.nextLine();
        LocalDate datee = LocalDate.parse(date);
        Enseignant enseignant = enseignantController.addEnseignant(new Enseignant(0,matricule,nom,prenom,tel,chargesem,salairemensu,datee)) ;
        if(enseignant!=null) affMsg("création de :"+enseignant);
        else affMsg("erreur de création");
    }

    @Override
    public Enseignant selectionner() {
        update(enseignantController.getAll());
        int nl = choixListe(cl);
        Enseignant ens = cl.get(nl - 1);
        return ens;
    }
}

