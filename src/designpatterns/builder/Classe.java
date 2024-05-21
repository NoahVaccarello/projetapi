package designpatterns.builder;

import Ecole.metier.Infos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Classe {
    protected static int id = 1;
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
    protected List<Infos> listInfo = new ArrayList<>();

    private Classe(ClasseBuilder builder) {
        this.idClasse = builder.id_classe;
        this.sigle = builder.sigle;
        this.annee = builder.annee;
        this.specialite = builder.specialite;
        this.nbreEleves = builder.nbreEleves;
    }

    public int getId_classe() {
        return id;
    }

    public String getSigle() {
        return sigle;
    }

    public int getAnnee() {
        return annee;
    }

    public String getSpecialite() {
        return specialite;
    }

    public int getNbreEleve() {
        return nbreEleves;
    }

    public List<Infos> getListInfo() {
        return listInfo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return id == classe.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Classe{" +
                "id=" + id +
                ", sigle='" + sigle + '\'' +
                ", annee=" + annee +
                ", specialite='" + specialite + '\'' +
                ", nbreEleve=" + nbreEleves +
                '}';
    }

    public static class ClasseBuilder {
        private int id_classe;
        private String sigle;
        private int annee;
        private String specialite;
        private int nbreEleves;

        public ClasseBuilder setId_classe(int id_classe) {
            this.id_classe = id_classe;
            return this;
        }

        public ClasseBuilder setSigle(String sigle) {
            this.sigle = sigle;
            return this;
        }

        public ClasseBuilder setAnnee(int annee) {
            this.annee = annee;
            return this;
        }

        public ClasseBuilder setSpecialite(String specialite) {
            this.specialite = specialite;
            return this;
        }

        public ClasseBuilder setNbreEleves(int nbreEleves) {
            this.nbreEleves = nbreEleves;
            return this;
        }


        public Classe build() throws Exception {
            if(sigle == null || annee == 0) {
                throw new Exception("info incomplètes");
            }
            return new Classe(this);
        }
    }
}