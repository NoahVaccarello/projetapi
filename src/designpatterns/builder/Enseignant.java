package designpatterns.builder;

import java.time.LocalDate;
import java.util.Date;

public class Enseignant {

    protected static int id=1;
    /**
     *  id de l'enseignant
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

    protected Date dateEngag;

    protected double salaireMensu;


    private Enseignant(EnseignantBuilder cb) {
        this.idEnseignant = cb.id_enseignant;
        this.matricule = cb.matricule;
        this.nom = cb.nom;
        this.prenom = cb.prenom;
        this.tel = cb.tel;
        this.chargeSem = cb.chargeSem;
        this.salaireMensu = cb.salaireMensu;
        this.dateEngag = cb.dateengag;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public int getChargeSem() {
        return chargeSem;
    }

    public double getSalaireMensu() {
        return salaireMensu;
    }

    public Date getDateEngag() {
        return dateEngag;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Enseignant other = (Enseignant) obj;
        return this.idEnseignant == other.idEnseignant;
    }

    public static class EnseignantBuilder {
        protected int id_enseignant;
        protected String matricule;
        protected String nom;
        protected String prenom;
        protected String tel;
        protected int chargeSem;
        protected double salaireMensu;
        protected Date dateengag;

        public EnseignantBuilder setId_enseignant(int id_enseignant) {
            this.id_enseignant = id_enseignant;
            return this;
        }

        public EnseignantBuilder setMatricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public EnseignantBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public EnseignantBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public EnseignantBuilder setCp(String tel) {
            this.tel = tel;
            return this;
        }

        public EnseignantBuilder setChargesem(int chargeSem) {
            this.chargeSem = chargeSem;
            return this;
        }

        public EnseignantBuilder setRue(double salaireMensu) {
            this.salaireMensu = salaireMensu;
            return this;
        }

        public EnseignantBuilder setNum(Date dateengag) {
            this.dateengag = dateengag;
            return this;
        }

        public Enseignant build() throws Exception {
            if (id_enseignant <= 0 || matricule == null || nom == null || prenom == null) {
                throw new Exception("informations de construction incomplètes");
            }
            return new Enseignant(this);
        }
    }
}