package designpatterns.observer;

import Ecole.metier.Infos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * classe métier de gestion d'un produit
 * @author Michel Poriaux
 * @version 1.0
 */
public class Classe extends Subject{

    protected static int id = 1;
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
     * constructeur par défaut
     */
    public Classe() {
    }
    /**
     * constructeur paramétré
     *
     * @param sigle      nom du sigle alphanumérique de la classe
     * @param annee      annee de la classe
     * @param specialite nom de la specialité
     * @param nbreEleves nombre d'eleve dans la classe
     */

    public Classe(String sigle, int annee, String specialite, int nbreEleves) {
        this.idClasse = id++;
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
     * affichage des infos du produit
     * @return description complète du produit
     */
    @Override
    public String toString() {
        return "Classe{" + "idclasse="+idClasse+", sigle=" + sigle + ", specialite=" + specialite + ", annee=" + annee + ", nbreleve=" + nbreEleves + '}';
    }

    @Override
    public String getNotification() {
        return "nouveau nbreEleve = "+nbreEleves;
    }




}


