package Ecole;

import Ecole.Classe;
import Ecole.Cours;
import Ecole.Enseignant;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe metier de gestion des infos
 *
 * @author Noah Vaccarello
 * @version 1.0
 */

public class Infos {

    /**
     * identifiant des infos
     */
    protected int idInfo;
    /**
     * nombre d'heures de cours
     */
    protected int nbreHeures;
    /**
     * cours d'une classe
     */
    protected Cours cours;

    /**
     * enseignant d'un cours
     */
    protected Enseignant enseignant;
    /**
     * salle du cours
     */
    protected Salle salle;

    /**
     * @param cours      cours d'une classe
     * @param nbreHeures nombre d'heures de cours
     */
    public Infos(Cours cours, int nbreHeures) {
        this.cours = cours;
        this.nbreHeures = nbreHeures;
    }

    /**
     * @param idInfo     identifiant des infos
     * @param nbreHeures nombre d'heures de cours
     * @param cours      cours d'une classe
     * @param enseignant enseignant d'un cours
     * @param salle      salle du cours
     */

    public Infos(int idInfo, int nbreHeures, Cours cours, Enseignant enseignant, Salle salle) {
        this.idInfo = idInfo;
        this.nbreHeures = nbreHeures;
        this.cours = cours;
        this.enseignant = enseignant;
        this.salle = salle;
    }

    /**
     * identifiant des infos
     *
     * @return identifiant des infos
     */

    public Cours getCours() {
        return cours;
    }

    /**
     * identifiant des infos
     *
     * @param cours identifiant des infos
     */
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    /**
     * getter identifiant des infos
     *
     * @return identifiant des infos
     */
    public int getIdInfo() {
        return idInfo;
    }

    /**
     * setter identifiant des infos
     *
     * @param idInfo identifiant des infos
     */

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
    }

    /**
     * getter nombre d'heure de cours
     *
     * @return nombre d'heure de cours
     */

    public int getNbreHeures() {
        return nbreHeures;
    }

    /**
     * setter nombre d'heure de cours
     *
     * @param nbreHeures nombre d'heure de cours
     */

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    /**
     * getter des enseignant du cours
     *
     * @return des enseignant du cours
     */
    public Enseignant getEnseignant() {
        return enseignant;
    }

    /**
     * setter des enseignant du cours
     *
     * @param enseignant des enseignant du cours
     */
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    /**
     * getter de la salle du cours
     *
     * @return de la salle du cours
     */
    public Salle getSalle() {
        return salle;
    }

    /**
     * setter des enseignant du cours
     *
     * @param salle des enseignant du cours
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Infos{" +
                "idInfo=" + idInfo +
                ", nbreHeures=" + nbreHeures +
                ", cours=" + cours +
                ", enseignant=" + enseignant +
                ", salle=" + salle +
                '}';
    }
}
