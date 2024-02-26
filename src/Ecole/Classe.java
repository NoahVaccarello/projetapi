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
    protected List<EnseignantEtHeures> enseignantEtHeures = new ArrayList<>();
    /**
     * liste des cours et heures associées
     */
    protected List<listeCoursEtHeures> coursEtHeures = new ArrayList<>();
     /**
     * liste des salles et heures associées
     */
    protected List<listeSalleetHeures> salleetHeures = new ArrayList<>();

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
     * @param salle salle du cours
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
     * @param cours cours de la classe
     * @param heures heures du cours
     */

    public void addCours(Cours cours, int heures) {
        for (Infos infos : listInfo){
            if (infos.getCours().getIdCours().equals(cours.getIdCours())){
                System.out.println("Impossible d'ajouter le cours (doublon)");;
            }
            else{
                listInfo.add(new Infos(cours,heures));
                System.out.println("Cours ajouté avec succès");
            }
        }
    }
            //if(infos.getCours().getIdCours().equals(cours.getIdCours())) {


    /**
     * Modifie le cours avec un nouvel enseignant
     * @param Chcours cours de la classe
     * @param newEnseignant nouvel enseignant assignée au cours
     */
    public void modifCours(Cours Chcours, Enseignant newEnseignant) {

        for(Infos infos : listInfo){
            if (infos.getCours().equals(Chcours)){
                infos.setEnseignant(newEnseignant);
                System.out.println("Un nouvel enseignant à été assigné");
            }
        }
    }

    /**
     * Modifie le cours avec une nouvelle salle
     * @param Chcours cours de la classe
     * @param newSalle nouvelle salle assigné au cours
     */
    public void modifCours(Cours Chcours, Salle newSalle) {
        for(Infos infos : listInfo){
            if (infos.getCours().equals(Chcours)){
                infos.setSalle(newSalle);
                System.out.println("Une nouvelle salle à été assignée");
            }
        }
    }

    /**
     * Modifie le nombre d'heures attribuées à un cours
     * @param Chcours cours de la classe
     * @param newHeures nouvelle heure de cours
     */
    public void modifCours(Cours Chcours, int newHeures) {

        for(Infos infos : listInfo){
            if (infos.getCours().equals(Chcours)){
                infos.setNbreHeures(newHeures);
                System.out.println("Un nouvel horaire à été assigné");
            }
        }
    }

    /**
     * Permet de supprimer un cours de la liste
     * @param cours cours à supprimé
     */

    public void suppCours(Infos cours){
        for (Infos infos : listInfo){
            if (infos.getCours().equals(cours)){
                listInfo.remove(cours);
            }
            else {
                System.out.println("Ce cours n'existe pas");
            }
        }
    }

    /**
     *  liste de la salle et l'heure de cours
     * @return la salle et l'heure
     */
    public List<listeSalleetHeures> listeSalleetHeures(){
        for(Infos infos : listInfo){
            salleetHeures.add(new listeSalleetHeures(infos.getSalle(), infos.getNbreHeures()));
        }
        return salleetHeures;
    }

    /**
     * liste des cours et des heures
     * @return cours et des heures
     */

    public List<listeCoursEtHeures> listeCoursEtHeures(){

        for (Infos infos : listInfo){
            coursEtHeures.add(new listeCoursEtHeures(infos.getCours(),infos.getNbreHeures()));
        }
        return coursEtHeures;
    }

    /**
     * liste des enseignant et de leurs heures de cours
     * @return les enseignant et de leurs heures
     */

    public List<EnseignantEtHeures> EnseignantEtHeures(){

        for (Infos infos : listInfo){
            enseignantEtHeures.add(new EnseignantEtHeures(infos.getEnseignant(), infos.getNbreHeures()));
        }

        return enseignantEtHeures;
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
