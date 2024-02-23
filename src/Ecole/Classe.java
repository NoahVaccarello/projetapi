package Ecole;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe metier de gestion d'une classe d'école
 * @author Noah Vaccarello
 * @version 1.0
 */

public class Classe {

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
    protected List <Infos> listInfo = new ArrayList<>() ;
    /**
     * liste des enseignants et heures associées
     */
    protected List<EnseignantEtHeures> listeEnseignEtHeures = new ArrayList<>();
    /**
     * liste des cours et heures associées
     */
    protected List<listeCoursEtHeures> listeCoursEtHeures = new ArrayList<>();
     /**
     * liste des salles et heures associées
     */
    protected List<listeSalleetHeures> listeSalleetHeures = new ArrayList<>();

    /**
     * constructeur paramétré
     *
     * @param idClasse identifiant de la classe
     * @param sigle nom du sigle alphanumérique de la classe
     * @param annee annee de la classe
     * @param specialite nom de la specialité
     * @param nbreEleves nombre d'eleve dans la classe
     */

    public Classe(int idClasse, String sigle, int annee, String specialite, int nbreEleves) {
        this.idClasse = idClasse;
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;

    }

    /**
     * getter de l'id de la classe
     * @return de l'id de la classe
     */

    public int getIdClasse() {
        return idClasse;
    }

    /**
     * setter de l'id de la classe
     * @param idClasse id de la classe
     */

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    /**
     * getter du sigle de la classe
     * @return du sigle de la classe
     */

    public String getSigle() {
        return sigle;
    }

    /**
     * setter du sigle de la classe
     * @param sigle sigle de la classe
     */

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     * getter de l'année de la classe
     * @return de l'année de la classe
     */

    public int getAnnee() {
        return annee;
    }

    /**
     * setter de l'année de la classe
     * @param annee l'année de la classe
     */

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     * getter de la spécialité de la classe
     * @return de la spécialité de la classe
     */

    public String getSpecialite() {
        return specialite;
    }

    /**
     * setter de la spécialité de la classe
     * @param specialite la spécialité de la classe
     */

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * getter du nombre d'élève de la classe
     * @return du nombre d'élève de la classe
     */

    public int getNbreEleves() {
        return nbreEleves;
    }

    /**
     * setter du nombre d'élève de la classe
     * @param nbreEleves nombre d'élève de la classe
     */

    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    /**
     * getter le cours de la classe
     * @return le cours de la classe
     */

    public List<Infos> getListInfo() {
        return listInfo;
    }

    /**
     * setter le cours de la classe
     * @param listInfo le cours de la classe
     */
    public void setListInfo(List<Infos> listInfo) {
        this.listInfo = listInfo;
    }


    /**
     * Calcul du nombre total d'heures de cours pour cette classe
     * @return
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
     * @param salle
     * @return
     */
    public boolean salleCapacitOK(Salle salle) {

        if (salle.capacite<=getNbreEleves()) {

            System.out.println("La salle de classe est disponible");
            return true ;
        }

        else {
            System.out.println("Salle de classe indisponible");
            return false;
        }
    }

    /**
     * Ajoute un cours avec un nombre d'heures spécifié à la classe
     * @param cours
     * @param heures
     */
    public void addCours(Cours cours, int heures) {
        //TODO
    }

    /**
     * Modifie le cours avec un nouvel enseignant
     * @param cours
     * @param newEnseignant
     */
    public void modifCours(Cours cours, Enseignant newEnseignant) {

        for(Infos infos : listInfo){
            if (infos.getCours().equals(cours)){
                infos.setEnseignant(newEnseignant);
                System.out.println("Un nouvelle enseignant à été assigné");
            }
        }
    }

    /**
     * Modifie le cours avec une nouvelle salle
     * @param cours
     * @param newSalle
     */
    public void modifCours(Cours cours, Salle newSalle) {
        for(Infos infos : listInfo){
            if (infos.getCours().equals(cours)){
                infos.setSalle(newSalle);
                System.out.println("Un nouvelle enseignant à été assigné");
            }
        }
    }

    /**
     * Modifie le nombre d'heures attribuées à un cours
     * @param cours
     * @param newHeures
     */
    public void modifCours(Cours cours, int newHeures) {

        for(Infos infos : listInfo){
            if (infos.getCours().equals(cours)){
                infos.setNbreHeures(newHeures);
                System.out.println("Un nouvelle horaire à été assigné");
            }
        }
    }

    /**
     * Permet de supprimer un cours de la liste
     * @param cours
     */

    public void suppCours(Cours cours){
        for (Infos infos : listInfo){
            if (infos.getCours().equals(cours)){
                listInfo.remove(cours);
            }
        }
    }

    /**
     * Affiche la liste des salles et des heures
     */

    public void listeSalleetHeures(){
        int i ;
        for (i=0;i<listeEnseignEtHeures.size();i++){

            System.out.println(listeEnseignEtHeures);
        }
    }

    /**
     * Affiche la liste des cours et des heures
     */

    public void listeCoursEtHeures(){
        int i ;
        for (i=0;i<listeCoursEtHeures.size();i++){

            System.out.println(listeCoursEtHeures);
        }
    }

    /**
     * Affiche la liste des enseignant et des heures
     */

    public void EnseignantEtHeures(){
        int i ;
        for (i=0;i<listeEnseignEtHeures.size();i++){

            System.out.println(listeEnseignEtHeures);
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return idClasse == classe.idClasse && annee == classe.annee && nbreEleves == classe.nbreEleves && Objects.equals(sigle, classe.sigle) && Objects.equals(specialite, classe.specialite) && Objects.equals(listInfo, classe.listInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClasse, sigle, annee, specialite, nbreEleves, listInfo);
    }

    @Override
    public String toString() {
        return "Classe{" +
                "idClasse=" + idClasse +
                ", sigle='" + sigle + '\'' +
                ", annee=" + annee +
                ", specialite='" + specialite + '\'' +
                ", nbreEleves=" + nbreEleves +
                '}';
    }
}
