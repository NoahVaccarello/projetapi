package mvc.view;

import Ecole.metier.Classe;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class ClasseViewConsole extends ClasseAbstractView {
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

        Classe cla = cl.get(nl-1);
        String sigle= modifyIfNotBlank("numéro du sigle",cla.getSigle());
        int annee = Integer.parseInt(modifyIfNotBlank("Annee de cours",""+cla.getAnnee()));
        String specialite = modifyIfNotBlank("Specialite : ",cla.getSpecialite());
        int nbreEleves = Integer.parseInt(modifyIfNotBlank("Nombre d'élvève ",""+cla.getNbreEleves()));
        Classe clamaj = classeController.updateClasse(new Classe(cla.getIdClasse(),sigle,annee,specialite,nbreEleves));
        if(clamaj==null) affMsg("mise à jour infrucueuse");
        else affMsg("mise à jour effectuée : "+clamaj);
    }

    private void rechercher() {
        System.out.println("id de la classe : ");
        int id_classe = sc.nextInt();
        classeController.searchClasse(id_classe);
    }

    private void retirer() {

        int nl = choixElt(cl);
        Classe cla = cl.get(nl-1);
        boolean ok = classeController.removeClasse(cla);
        if(ok) affMsg("classe effacé");
        else affMsg("classe non effacé");
    }

    private void ajouter() {
        System.out.print("numéro du sigle : ");
        String sigle= sc.nextLine();
        System.out.print("Année : ");
        int annee = sc.nextInt();
        System.out.print("Specialité :");
        String specialite = sc.nextLine();
        System.out.print("Nombre d'élève : ");
        int nbreEleves = Integer.parseInt(sc.next());
        Classe cla = classeController.addClasse(new Classe(0,sigle,annee,specialite,nbreEleves)) ;
        if(cla!=null) affMsg("création de :"+cla);
        else affMsg("erreur de création");
    }

    @Override
    public Classe selectionner(){
        update(classeController.getAll());
        int nl =  choixListe(cl);
        Classe cla = cl.get(nl-1);
        return cla;
    }
}

