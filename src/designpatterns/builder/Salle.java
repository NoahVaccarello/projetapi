package designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

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

    protected List<Cours> cours = new ArrayList<>();

    private Salle(SalleBuilder cb) {
        this.idSalle = cb.idSalle;
        this.sigle = cb.sigle;
        this.capacite = cb.capacite;
    }

    public String getSigle() {
        return sigle;
    }

    public int getCapacite() {
        return capacite;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public int getId_salle() {
        return idSalle;
    }

    public static class SalleBuilder {
        protected int idSalle;
        protected String sigle;
        protected int capacite;

        public SalleBuilder setId_salle(int idSalle) {
            this.idSalle = idSalle;
            return this;
        }

        public SalleBuilder setSigle(String sigle) {
            this.sigle = sigle;
            return this;
        }

        public SalleBuilder setCapacite(int capacite) {
            this.capacite = capacite;
            return this;
        }

        public Salle build() throws Exception {
            if (idSalle <= 0 || sigle == null) throw new Exception("informations de construction incomplètes");
            return new Salle(this);
        }
    }
}
