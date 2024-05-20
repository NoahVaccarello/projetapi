package mvc.model;


import Ecole.metier.Classe;
import myconnections.DBConnection;


import java.math.BigDecimal;
import java.sql.*;
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
        String query1 = "insert into API2_CLASSE(sigle,annee,specialite,nbreEleves) values(?,?,?,?)";
        String query2 = "select id_classe from API2_CLASSE where sigle= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,classe.getSigle());
            pstm1.setInt(2,classe.getIdClasse());
            pstm1.setString(3,classe.getSpecialite());
            pstm1.setInt(4,classe.getAnnee());
            pstm1.setInt(5,classe.getNbreEleves());
            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setInt(1,classe.getIdClasse());
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
            //System.err.println("erreur sql :"+e);

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
        String query = "update API2_CLASSE set sigle =?,annee=?,specialite=?,nbreEleves=? where id_classe = ?";
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
    public List getNotification() {
        return getClasse();
    }
}
