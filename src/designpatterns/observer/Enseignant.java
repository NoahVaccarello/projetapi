package designpatterns.observer;

import java.util.Date;

public class Enseignant extends Observer {

    protected static int id = 1;
    /**
     * id de l'enseignant
     */
    protected int idEnseignant;
    /**
     * matricule de l'enseignant
     */
    protected String matricule;
    /**
     * nom de l'enseignant
     */
    protected String nom;
    /**
     * prenom de l'enseignant
     */
    protected String prenom;
    /**
     * numéro de téléphone l'enseignant
     */
    protected String tel;
    /**
     * charge de la semaine l'enseignant
     */
    protected int chargeSem;
    /**
     * salaire mensuel de l'enseignant
     */
    protected double salaireMensu;
    /**
     * date d'engagement de l'enseignant
     */
    protected Date dateEngag;

    /**
     * @param matricule matricule de l'enseignant
     * @param nom       nom de l'enseignant
     * @param prenom    prenom de l'enseignant
     * @param tel       numéro de téléphone l'enseignant
     * @param chargeSem charge de la semaine l'enseignant
     * @param dateEngag date d'engagement l'enseignant
     */

    public Enseignant(int idEnseignant, String matricule, String nom, String prenom, String tel, int chargeSem, double salaireMensu, Date dateEngag) {
        this.idEnseignant = id++;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.salaireMensu = salaireMensu;
        this.dateEngag = dateEngag;
    }

    /**
     * getter de l'id enseignant
     *
     * @return id enseignant
     */

    public int getIdEnseignant() {
        return idEnseignant;
    }

    /**
     * setter de l'id enseignant
     *
     * @param idEnseignant id enseignant
     */

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    /**
     * getter du matricule
     *
     * @return matricule
     */

    public String getMatricule() {
        return matricule;
    }

    /**
     * setter de l'id enseignant
     *
     * @param matricule matricule
     */

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * getter du nom enseignant
     *
     * @return nom
     */

    public String getNom() {
        return nom;
    }

    /**
     * setter du nom de l'enseignant
     *
     * @param nom de l'enseignant
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter du prenom
     *
     * @return du prenom
     */

    public String getPrenom() {
        return prenom;
    }

    /**
     * setter de l'enseignant
     *
     * @param prenom de l'enseignant
     */

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter du numéro de tel de l'enseignant
     *
     * @return du numéro de tel
     */

    public String getTel() {
        return tel;
    }

    /**
     * setter du numéro de tel de l'enseignant
     *
     * @param tel du numéro de tel de l'enseignant
     */

    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * getter de la charge semaine
     *
     * @return de la charge semaine
     */

    public int getChargeSem() {
        return chargeSem;
    }

    /**
     * setter de la charge semaine
     *
     * @param chargeSem de la charge semaine
     */

    public void setChargeSem(int chargeSem) {
        this.chargeSem = chargeSem;
    }

    public void setDateEngag(Date dateEngag) {
        this.dateEngag = dateEngag;
    }

    public Date getDateEngag() {
        return dateEngag;
    }

    public double getSalaireMensu() {
        return salaireMensu;
    }

    public void setSalaireMensu(double salaireMensu) {
        this.salaireMensu = salaireMensu;
    }

    @Override
    public void update(String msg) {
        System.out.println(prenom + nom + "a reçu le message : "+ msg);
    }
}
