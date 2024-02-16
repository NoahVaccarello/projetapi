package Ecole;

import Ecole.Cours;

import java.util.ArrayList;
import java.util.List;

public class Salle {

    protected int idSalle;
    protected String sigle;
    protected int capacite;
    protected List<Cours> salleParDefaut = new ArrayList<>();

    public Salle(int idSalle, String sigle, int capacite, List<Cours> salleParDefaut) {
        this.idSalle = idSalle;
        this.sigle = sigle;
        this.capacite = capacite;
        this.salleParDefaut = salleParDefaut;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Cours> getSalleParDefaut() {
        return salleParDefaut;
    }

    public void setSalleParDefaut(List<Cours> salleParDefaut) {
        this.salleParDefaut = salleParDefaut;
    }
}
