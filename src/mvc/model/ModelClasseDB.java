package mvc.model;


import Ecole.metier.*;
import myconnections.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ModelClasseDB extends DAOclasse{

    protected Connection dbConnect;

    public ModelClasseDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

    }

    @Override
    public Classe addClasse (Classe classe) {
        String query1 = "insert into API2_CLASSE(SIGLE,ANNEE,SPECIALITE,NBREELEVES) values(?,?,?,?)";
        String query2 = "select ID_CLASSE from API2_CLASSE where SIGLE= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,classe.getSigle());
            pstm1.setInt(2,classe.getAnnee());
            pstm1.setString(3,classe.getSpecialite());
            pstm1.setInt(4,classe.getNbreEleves());
            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setString(1,classe.getSigle());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int idclasse= rs.getInt(1);
                    classe.setIdClasse(idclasse);
                    notifyObservers();
                    return classe;
                }
                else {

                    System.err.println("record introuvable");
                    return null;
                }
            }
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public boolean removeClasse(Classe classe) {
        String query = "delete from API2_CLASSE where id_classe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,classe.getIdClasse());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return false;
        }
    }

    @Override
    public Classe updateClasse(Classe classe) {
        String query = "update API2_CLASSE set SIGLE =?,ANNEE=?,SPECIALITE=?,NBREELEVESs=? where ID_CLASSE = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, classe.getSigle());
            pstm.setInt(2,classe.getAnnee());
            pstm.setString(3, classe.getSpecialite());
            pstm.setInt(4,classe.getNbreEleves());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return readClasse(classe.getIdClasse());
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public Classe readClasse(int id_classe) {
        String query = "select * from API2_CLASSE where id_classe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_classe);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String sigle = rs.getString(2);
                int annee = rs.getInt(3);
                String specialite = rs.getString(4);
                int nbreEleves  = rs.getInt(5);
                Classe cl = new Classe(id_classe,sigle,annee,specialite,nbreEleves);
                return  cl;

            }
            else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public List<Classe> getClasse() {
        List<Classe> lp = new ArrayList<>();
        String query="select * from API2_CLASSE";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_classe = rs.getInt(1);
                String sigle = rs.getString(2);
                int annee = rs.getInt(3);
                String specialite = rs.getString(4);
                int nbreEleves  = rs.getInt(5);
                Classe cl = new Classe(id_classe,sigle,annee,specialite,nbreEleves);
                lp.add(cl);
            }
            return lp;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public boolean addCours(Classe classe, Cours cours, int nbrheure) {
        String query = "insert into  API2_COURS(id_cours,code,intitule,id_salle) values(?,?,?,?)";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,classe.getIdClasse());
            pstm.setInt(2,cours.getId_cours());
            pstm.setInt(3,nbrheure);
            pstm.setInt(4,cours.getSalleParDefaut().getIdSalle());
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return false;
        }
    }

    @Override
    public boolean modifCours(Classe classe, Cours cours, Salle salle) {
        String query = "update  API2_COURS set id_salle = ? where id_classe = ? AND id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,salle.getIdSalle());
            pstm.setInt(2,cours.getId_cours());
            pstm.setInt(3,classe.getIdClasse());
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public boolean modifCours(Classe classe, Cours cours, Enseignant enseignant) {
        String query = "update  API2_COURS set id_enseignant = ? where id_classe = ? AND id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,enseignant.getIdEnseignant());
            pstm.setInt(2,cours.getId_cours());
            pstm.setInt(3,classe.getIdClasse());
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public boolean modifCours(Classe classe, Cours cours, int nbrheure) {
        String query = "update  API2_COURS set nbrheure = ? where id_classe = ? AND id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,nbrheure);
            pstm.setInt(2,cours.getId_cours());
            pstm.setInt(3,classe.getIdClasse());
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public boolean suppCours(Classe classe, Cours cours) {

        String query = "DELETE FROM  API2_COURS where  id_classe = ? AND id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,classe.getIdClasse());
            pstm.setInt(2,cours.getId_cours());
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public List<Infos> getCours(Classe classe) {

        String query = "SELECT * FROM  API2_COURS where  id_classe = ?";
        List<Infos> ll = new ArrayList<>();
        try(PreparedStatement pstm = dbConnect.prepareStatement(query) ){
            pstm.setInt(1,classe.getIdClasse());
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                //todo
                int id_cours = rs.getInt("Id du cours");
                String code = rs.getString("Code du cours");
                String intitule = rs.getString("Intitule du cours");
                int id_salle = rs.getInt("Id de la salle");
                //Salle salleParDefaut= salleController.searchSalle(id_salle);
                //Infos i = new Cours(id_cours, code, intitule, salleParDefaut);
                //pour faire cela je dois donc demander cours enseignant ect...
                //ll.add(i);
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }
        return ll;
    }



    @Override
    public int nbrHeuresTot(Classe classe) {
        //todo
        return 0;
    }

    @Override
    public List<EnseignantEtHeures>  enseignantEtHeures(Classe classe) {
        String query = "SELECT * FROM API2_INFOS WHERE id_classe = ?";
        String query2 = "SELECT * FROM API2_ENSEIGNANT WHERE id_enseignant = ?";
        List<EnseignantEtHeures> listEH = new ArrayList<>();
        try (PreparedStatement pstm = dbConnect.prepareStatement(query);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            pstm.setInt(1, classe.getIdClasse());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id_enseignant = rs.getInt(2);
                int nbh = rs.getInt(3);
                pstm2.setInt(1, id_enseignant);
                ResultSet rs2 = pstm2.executeQuery();
                Enseignant ens = null;
                if (rs2.next()) {
                    String matricule = rs2.getString(2);
                    String nom = rs2.getString(3);
                    String prenom = rs2.getString(4);
                    String tel = rs2.getString(5);
                    int chargesem = rs2.getInt(6);
                    Double salairemensu = rs2.getDouble(7);
                    LocalDate dateengag = rs2.getDate(8).toLocalDate();
                    ens = new Enseignant(id_enseignant, matricule, nom,prenom,tel,chargesem,salairemensu,dateengag);
                }
                EnseignantEtHeures listEnsHeure = new EnseignantEtHeures(ens,nbh);
                listEH.add(listEnsHeure);
            }
            return listEH;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public List<ListeCoursEtHeures> coursEtHeures(Classe classe) {
        String query = "SELECT * FROM API2_INFOS WHERE id_classe = ?";
        String query2 = "SELECT * FROM API2_COURS WHERE id_cours = ?";
        String query3 = "SELECT * FROM Salles WHERE id_salle = ?";
        List<ListeCoursEtHeures> listCH = new ArrayList<>();
        try (PreparedStatement pstm = dbConnect.prepareStatement(query);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
             PreparedStatement pstm3 = dbConnect.prepareStatement(query3)) {
            pstm.setInt(1, classe.getIdClasse());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id_cours = rs.getInt(2);
                int nbh = rs.getInt(3);
                pstm2.setInt(1, id_cours);
                ResultSet rs2 = pstm2.executeQuery();
                Cours cours = null;
                if (rs2.next()) {
                    String matricule = rs2.getString(2);
                    String code = rs2.getString(3);
                    int id_salle = rs2.getInt(4);

                    pstm3.setInt(1, id_salle);
                    ResultSet rs3 = pstm3.executeQuery();
                    Salle salle = null;
                    if (rs3.next()) {
                        String nomSalle = rs3.getString("nomSalle");
                        int capacite = rs3.getInt("capacite");
                        salle = new Salle(id_salle, nomSalle, capacite);
                    }

                    cours = new Cours(id_cours, matricule, code, salle);
                }
                ListeCoursEtHeures listCoHe = new ListeCoursEtHeures(cours, nbh);
                listCH.add(listCoHe);
            }
            return listCH;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public List<ListeSalleetHeures> salleetHeures(Classe classe) {
        String query = "SELECT * FROM API2_INFOS WHERE id_classe = ?";
        String query2 = "SELECT * FROM API2_SALLE WHERE id_salle = ?";
        List<ListeSalleetHeures> listSH = new ArrayList<>();
        try (PreparedStatement pstm = dbConnect.prepareStatement(query);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            pstm.setInt(1, classe.getIdClasse());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id_salle = rs.getInt(2);
                int nbh = rs.getInt(3);
                pstm2.setInt(1, id_salle);
                ResultSet rs2 = pstm2.executeQuery();
                Salle salle = null;
                if (rs2.next()) {
                    String sigle = rs2.getString(2);
                    int capacite = rs2.getInt(3);
                    salle = new Salle(id_salle,sigle,capacite);
                }
                ListeSalleetHeures listeSalleetHeures = new ListeSalleetHeures(salle,nbh);
                listSH.add(listeSalleetHeures);
            }
            return listSH;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public boolean salleCapacitOK(Salle salle) {

        //todo

        return false;
    }

    @Override
    public List getNotification() {
        return getClasse();
    }


}
