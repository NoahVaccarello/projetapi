package mvc.view;

import Ecole.metier.Classe;
import Ecole.metier.Cours;
import Ecole.metier.Salle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static utilitaires.Utilitaire.*;

public class SalleViewConsole extends SalleAbstractView {
    private Scanner sc = new Scanner(System.in);


    @Override
    public void affMsg(String msg) {
        System.out.println("information:"+msg);
    }

    @Override
    public void affList(List infos) {
        affListe(infos);
    }


    public void menu(){
        update(salleController.getAll());
        do{
            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "fin"));

            switch(ch){
                case 1: ajouterSalle();
                    break;
                case 2 : retirer();
                    break;
                case 3: rechercher();
                    break;
                case 4 : modifier();
                    break;
                case 5 : return;
            }
        }while(true);
    }

    private void modifier() {
        int nl = choixListe(sl);
        Salle salle = sl.get(nl-1);
        String sigle = modifyIfNotBlank("sigle de la salle", salle.getSigle());
        int capacite = parseInt(modifyIfNotBlank("capacite de la salle", "" + salle.getCapacite()));
        Salle sal =salleController.updateSalle(new Salle(salle.getIdSalle(), sigle, capacite));
        if(sal==null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+sal);
    }

    private void rechercher() {
        System.out.println("id de la salle : ");
        int idSalle = sc.nextInt();
        Salle salle = salleController.searchSalle(idSalle);
        if(salle==null) affMsg("recherche infructueuse");
        else {
            affMsg(salle.toString());
        }

    }
    private void retirer() {

        int nl = choixElt(sl);
        Salle sal = sl.get(nl-1);
        boolean ok = salleController.removeSalle(sal);
        if(ok) affMsg("salle effacé");
        else affMsg("salle non effacé");
    }

    private void ajouterSalle() {
        System.out.print("sigle de la salle : ");
        String sigle = sc.next();
        System.out.print("capacité de la salle: ");
        int capacite = sc.nextInt();
        Salle sal = salleController.addSalle(new Salle(0, sigle, capacite));
        if(sal!=null) affMsg("création de :"+sal);// le message d'erreur s'affiche alord que la salle s'est bien ajouter dans la db
        else affMsg("erreur de création");
    }

    @Override
    public Salle selectionner(){
        update(salleController.getAll());
        int nl =  choixListe(sl);
        Salle sal = sl.get(nl-1);
        return sal;
    }
}

