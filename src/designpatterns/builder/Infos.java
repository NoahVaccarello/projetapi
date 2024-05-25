package designpatterns.builder;

import Ecole.metier.Salle;

public class Infos {
    protected static int id=1;
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
    private Infos(InfosBuilder cb) {
        this.idInfo = cb.idInfo;
        this.nbreHeures = cb.nbreHeures;
        this.cours = cb.cours;
        this.salle = cb.salle;
        this.enseignant = cb.enseignant;
    }

    public int getIdInfo() {
        return idInfo;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public Cours getCours() {
        return cours;
    }

    public Salle getSalle() {
        return salle;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public static class InfosBuilder {
        protected int idInfo;
        protected int nbreHeures;
        protected Cours cours;
        protected Salle salle;
        protected Enseignant enseignant;

        public InfosBuilder setId_infos(int idInfo) {
            this.idInfo = idInfo;
            return this;
        }

        public InfosBuilder setNbreheures(int nbreHeures) {
            this.nbreHeures = nbreHeures;
            return this;
        }

        public InfosBuilder setCours(Cours cours) {
            this.cours = cours;
            return this;
        }

        public InfosBuilder setSalle(Salle salle) {
            this.salle = salle;
            return this;
        }

        public InfosBuilder setEnseignant(Enseignant enseignant) {
            this.enseignant = enseignant;
            return this;
        }

        public Infos build() throws Exception {
            if (idInfo <= 0 || cours == null) {
                throw new Exception("informations de construction incomplètes");
            }
            return new Infos(this);
        }
    }
}
