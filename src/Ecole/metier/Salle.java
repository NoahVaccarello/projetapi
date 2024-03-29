package Ecole.metier;

import Ecole.metier.Cours;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe metier de gestion d'une classe d'école
 * @author Noah Vaccarello
 * @version 1.0
 */

public class Salle {

    protected static int id=1;
    /**
     * id de la salle
     */
    protected int idSalle;
    /**
     * sigle de la la classe
     */
    protected String sigle;
    /**
     * capacite de la salle
     */
    protected int capacite;
    /**
     * ensemble de la sallepardefaut
     */
    protected List<Cours> salleParDefaut = new ArrayList<>();

    /**
     * Constructeur paramétré
     * @param sigle sigle de la la classe
     * @param capacite capacite de la salle
     * @param salleParDefaut ensemble de la sallepardefaut
     */

    public Salle(String sigle, int capacite, List<Cours> salleParDefaut) {
        this.idSalle = id++;
        this.sigle = sigle;
        this.capacite = capacite;
        this.salleParDefaut = salleParDefaut;
    }

    /**
     * getter de l'id de la salle
     * @return id de la salle
     */

    public int getIdSalle() {
        return idSalle;
    }

    /**
     * setter de l'id de la salle
     * @param idSalle id de la salle
     */

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    /**
     * getter du sigle
     * @return sigle
     */

    public String getSigle() {
        return sigle;
    }

    /**
     * setter du sigle
     * @param sigle du sigle
     */

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     * getter de la capacite
     * @return la capacite
     */

    public int getCapacite() {
        return capacite;
    }

    /**
     * setter de la capacite
     * @param capacite la capacite
     */

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    /**
     * getter de la salle par defaut
     * @return la salle par defaut
     */

    public List<Cours> getSalleParDefaut() {
        return salleParDefaut;
    }

    /**
     * setter de la salle par defaut
     * @param salleParDefaut la salle par defaut
     */

    public void setSalleParDefaut(List<Cours> salleParDefaut) {
        this.salleParDefaut = salleParDefaut;
    }
}
