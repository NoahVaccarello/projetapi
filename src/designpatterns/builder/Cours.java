package designpatterns.builder;

import Ecole.metier.Salle;

public class Cours {
    protected static int id = 1;
    protected int id_cours;
    protected String code;
    protected String intitule;
    protected Salle salleParDefaut;

    private Cours(CoursBuilder cb) {
        this.id_cours = cb.id_cours;
        this.code = cb.code;
        this.intitule = cb.intitule;
        this.salleParDefaut = cb.salleParDefaut;
    }

    public String getCode() {
        return code;
    }

    public String getIntitule() {
        return intitule;
    }

    public Salle getSalle() {
        return salleParDefaut;
    }

    public int getId_cours() {
        return id_cours;
    }

    public static class CoursBuilder {

        protected int id_cours;
        protected String code;
        protected String intitule;
        protected Salle salleParDefaut;

        public CoursBuilder setId_cours(int id_cours) {
            this.id_cours = id_cours;
            return this;
        }

        public CoursBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public CoursBuilder setIntitule(String intitule) {
            this.intitule = intitule;
            return this;
        }

        public CoursBuilder setSalle(Salle salleParDefaut) {
            this.salleParDefaut = salleParDefaut;
            return this;
        }

        public Cours build() throws Exception {
            if (id_cours <= 0 || code == null || intitule == null || salleParDefaut == null) {
                throw new Exception("informations de construction incomplètes");
            }
            return new Cours(this);
        }
    }
}
