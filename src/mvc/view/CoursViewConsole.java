package mvc.view;

import Ecole.metier.Cours;
import Ecole.metier.Cours;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class CoursViewConsole extends CoursAbstractView {
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
        update(classeController.getAll());
        do{
            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "fin"));

            switch(ch){
                case 1: ajouter();
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
        int nl = choixElt(cl);

        Cours c = cl.get(nl-1);
        String code= modifyIfNotBlank("numéro du code",c.getCode());
        String intitule = modifyIfNotBlank("Intitulé du cours"," "+c.getIntutle());
        String salleParDefaut = modifyIfNotBlank("Numéro de la salle : ",c.getSalleParDefaut());
        Cours cmaj = classeController.updateCours(new Cours(c.getId_cours(),code,intitule,salleParDefaut));
        if(cmaj==null) affMsg("mise à jour infrucueuse");
        else affMsg("mise à jour effectuée : "+cmaj);
    }

    private void rechercher() {
        System.out.println("id du cours : ");
        int id_classe = sc.nextInt();
        classeController.search(id_classe);
    }

    private void retirer() {

        int nl = choixElt(cl);
        Cours c = cl.get(nl-1);
        boolean ok = classeController.removeCours(c);
        if(ok) affMsg("cours effacé");
        else affMsg("cours non effacé");
    }

    private void ajouter() {
        System.out.print("numéro du code : ");
        String code= sc.nextLine();
        System.out.print("Intitule : ");
        String intitule = sc.nextLine();
        System.out.print("Salle par defaut :");
        String salleParDefaut = sc.nextLine();
        Cours c = classeController.addClasse(new Cours(0,code,intitule,salleParDefaut)) ;
        if(c!=null) affMsg("création de :"+c);
        else affMsg("erreur de création");
    }

    @Override
    public Cours selectionner(){
        update(classeController.getAll());
        int nl =  choixListe(cl);
        Cours c = cl.get(nl-1);
        return c;
    }
}

