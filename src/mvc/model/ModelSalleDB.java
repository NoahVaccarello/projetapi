package mvc.model;


import Ecole.metier.Salle;
import myconnections.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ModelSalleDB extends DAOsalle{

    protected Connection dbConnect;

    public ModelSalleDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

    }

    @Override
    public Salle addSalle (Salle salle) {
        String query1 = "insert into API2_Salle(sigle,capacite) values(?,?)";
        String query2 = "select id_salle from API2_CLASSE where sigle= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,salle.getSigle());
            pstm1.setInt(2,salle.getCapacite());
            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setInt(1,salle.getIdSalle());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int idclasse= rs.getInt(1);
                    salle.setIdSalle(idclasse);
                    notifyObservers();
                    return salle;
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
    public boolean removeSalle(Salle salle) {
        String query = "delete from API2_SALLE where id_salle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,salle.getIdSalle());
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
    public Salle updateSalle(Salle salle) {
        String query = "update API2_SALLE set sigle =?,capacite=?where id_salle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, salle.getSigle());
            pstm.setInt(2,salle.getCapacite());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return readSalle(salle.getIdSalle());
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public Salle searchSalle(Salle salle) {
        return null;
    }

    @Override
    public Salle readSalle(int idSalle) {
        String query = "select * from API2_SALLE where id_salle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idSalle);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String sigle = rs.getString(2);
                int capacite = rs.getInt(3);
                Salle sal = new Salle(idSalle,sigle,capacite);
                return sal;

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
    public List<Salle> getSalle() {
        List<Salle> sal = new ArrayList<>();
        String query="select * from API2_SALLE";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_salle = rs.getInt(1);
                String sigle = rs.getString(2);
                int capacite = rs.getInt(3);
                Salle sl = new Salle(id_salle,sigle,capacite);
                sal.add(sl);
            }
            return sal;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public List getNotification() {
        return getSalle();
    }
}
