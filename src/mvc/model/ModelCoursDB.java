/*package mvc.model;


import Ecole.metier.Cours;
import Ecole.metier.Salle;
import myconnections.DBConnection;


import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ModelCoursDB extends DAOcours{

    protected Connection dbConnect;

    public ModelCoursDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

    }

    @Override
    public Cours addCours (Cours cours) {
        String query1 = "insert into API2_COURS(code, intitule, salle) values(?,?,?)";
        String query2 = "select id_cours from API2_COURS where code= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,cours.getCode());
            pstm1.setString(2,cours.getIntutle());
        //  pstm1.setInt(3,cours.getSalleParDefaut().getIdSalle());
            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setInt(1,cours.getId_cours());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int idcours= rs.getInt(1);
                    cours.setId_cours(idcours);
                    notifyObservers();
                    return cours;
                }
                else {

                    System.err.println("record introuvable");
                    return null;
                }
            }
            else return null;

        } catch (SQLException e) {
            //System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public boolean removeCours(Cours cours) {
        String query = "delete from API2_CLASSE where id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,cours.getId_cours());
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
    public Cours updateCours(Cours cours) {
        String query = "update API2_COURS set code =?,intitule=?,id_salle=?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,cours.getCode());
            pstm.setString(2,cours.getIntutle());
            //  pstm.setInt(3,cours.getSalleParDefaut().getIdSalle());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return readCours(cours.getId_cours());
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public Cours readCours(int id_cours) {
        String query = "select * from API2_COURS where id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_cours);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String code = rs.getString(2);
                String intitule = rs.getString(3);
                int salleParDefaut = rs.getInt(4);
                //TODO
                Cours c = new Cours(id_cours,code,intitule,salleParDefaut);
                return c;

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
    public List<Cours> getCours() {
        List<Cours> lp = new ArrayList<>();
        String query="select * from API2_COURS";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_cours = rs.getInt(1);
                String code = rs.getString(2);
                String intitule = rs.getString(3);
                int salleParDefaut = rs.getInt(4);
                //TODO
                //Cours c = new Cours(id_cours,code,intitule,salleParDefaut);
                //lp.add(c);
            }
            return lp;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public List getNotification() {
        return getCours();
    }
}*/
