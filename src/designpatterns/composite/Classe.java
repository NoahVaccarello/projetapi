package designpatterns.composite;

import Ecole.metier.Cours;
import Ecole.metier.Enseignant;
import Ecole.metier.Infos;
import Ecole.metier.Salle;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Michel
 */
public class Classe extends Element{

    protected static int id = 1;
    /**
     * identifiant de la classe
     */
    protected int idClasse;
    /**
     * nom du sigle alphanumérique de la classe
     */
    protected String sigle;
    /**
     * annee de la classe
     */
    protected int annee;
    /**
     * nom de la specialité
     */
    protected String specialite;
    /**
     * nombre d'eleve dans la classe
     */
    protected int nbreEleves;
    /**
     * ensemble des infos d'une classe
     */
    protected List<Infos> listInfo = new ArrayList<>();

    /**
     * constructeur paramétré
     *
     *
     * @param sigle      sigle de la classe
     * @param annee      année en cours
     * @param specialite specialité de la classe
     * @param nbreEleves nombre d'élèves de la classe/**
     */
    public Classe(String sigle, int annee, String specialite, int nbreEleves) {
        this.idClasse = id++;
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;
    }

    /**
     * constructeur paramétré
     *
     * @param idClasse   id unique de la classe, affilié au i qui s'incrémente a chaque nouvelle classe
     * @param sigle      sigle de la classe
     * @param annee      année en cours
     * @param specialite specialité de la classe
     * @param nbreEleves nombre d'élèves de la classe/**
     */
    public Classe(int idClasse,String sigle, int annee, String specialite, int nbreEleves) {
        super(idClasse);
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;
    }

    /**
     * getter de l'id de la classe
     *
     * @return de l'id de la classe
     */

    public int getIdClasse() {
        return idClasse;
    }

    /**
     * setter de l'id de la classe
     *
     * @param idClasse id de la classe
     */

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    /**
     * getter du sigle de la classe
     *
     * @return du sigle de la classe
     */

    public String getSigle() {
        return sigle;
    }

    /**
     * setter du sigle de la classe
     *
     * @param sigle sigle de la classe
     */

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     * getter de l'année de la classe
     *
     * @return de l'année de la classe
     */

    public int getAnnee() {
        return annee;
    }

    /**
     * setter de l'année de la classe
     *
     * @param annee l'année de la classe
     */

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     * getter de la spécialité de la classe
     *
     * @return de la spécialité de la classe
     */

    public String getSpecialite() {
        return specialite;
    }

    /**
     * setter de la spécialité de la classe
     *
     * @param specialite la spécialité de la classe
     */

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * getter du nombre d'élève de la classe
     *
     * @return du nombre d'élève de la classe
     */

    public int getNbreEleves() {
        return nbreEleves;
    }

    /**
     * setter du nombre d'élève de la classe
     *
     * @param nbreEleves nombre d'élève de la classe
     */

    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    /**
     * getter le cours de la classe
     *
     * @return le cours de la classe
     */

    public List<Infos> getListInfo() {
        return listInfo;
    }

    /**
     * setter le cours de la classe
     *
     * @param listInfo le cours de la classe
     */
    public void setListInfo(List<Infos> listInfo) {
        this.listInfo = listInfo;
    }

    /**
     * Calcul du nombre total d'heures de cours pour cette classe
     *
     * @return total d'heure
     */
    public int nbreHeureTot() {

        int totalHeures = 0;
        for (Infos info : listInfo) {
            totalHeures += info.getNbreHeures();
        }
        return totalHeures;
    }

    /**
     * Verifie si la salle à la capacite d'accueillir une classe
     *
     * @param salle salle du cours
     * @return si la salle est dispo ou non
     */
    public boolean salleCapacitOK(Salle salle) {

        if (salle.getCapacite() <= getNbreEleves()) {

            System.out.println("La salle de classe est disponible");
            return true;
        } else {
            System.out.println("Salle de classe indisponible");
            return false;
        }
    }

    /**
     * Ajoute un cours avec un nombre d'heures spécifié à la classe
     *
     * @param cours  cours de la classe
     * @param heures heures du cours
     */

    public void addCours(Cours cours, int heures) {
        for (Infos infos : listInfo) {
            if (infos.getCours().getCode().equals(cours.getCode())) {
                System.out.println("Impossible d'ajouter le cours (doublon)");
                ;
            } else {
                listInfo.add(new Infos(cours, heures));
                System.out.println("Cours ajouté avec succès");
            }
        }
    }

    /**
     * Modifie le cours avec un nouvel enseignant
     *
     * @param Chcours       cours de la classe
     * @param newEnseignant nouvel enseignant assignée au cours
     */
    public void modifCours(Cours Chcours, Enseignant newEnseignant) {

        for (Infos infos : listInfo) {
            if (infos.getCours().equals(Chcours)) {
                infos.setEnseignant(newEnseignant);
                System.out.println("Un nouvel enseignant à été assigné");
            }
        }
    }

    /**
     * Modifie le cours avec une nouvelle salle
     *
     * @param Chcours  cours de la classe
     * @param newSalle nouvelle salle assigné au cours
     */
    public void modifCours(Cours Chcours, Salle newSalle) {
        for (Infos infos : listInfo) {
            if (infos.getCours().equals(Chcours)) {
                infos.setSalle(newSalle);
                System.out.println("Une nouvelle salle à été assignée");
            }
        }
    }

    /**
     * Modifie le nombre d'heures attribuées à un cours
     *
     * @param Chcours   cours de la classe
     * @param newHeures nouvelle heure de cours
     */
    public void modifCours(Cours Chcours, int newHeures) {

        for (Infos infos : listInfo) {
            if (infos.getCours().equals(Chcours)) {
                infos.setNbreHeures(newHeures);
                System.out.println("Un nouvel horaire à été assigné");
            }
        }
    }

    /**
     * Permet de supprimer un cours de la liste
     *
     * @param cours cours à supprimé
     */

    public boolean suppCours(Cours cours) {
        boolean ok = false;
        for (Infos info : listInfo) {
            if (info.getCours().equals(cours)) {
                listInfo.remove(info);
                ok = true;
                break;
            }
        }
        return ok;
    }


    @Override
    public int totalel() {
        return 0;
    }
}