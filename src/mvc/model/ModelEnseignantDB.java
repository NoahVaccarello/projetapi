package mvc.model;

import Ecole.metier.Enseignant;
import myconnections.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ModelEnseignantDB extends DAOenseignant{

    protected Connection dbConnect;

    public ModelEnseignantDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

    }

    @Override
    public Enseignant addEnseignant (Enseignant enseignant) {
        String query1 = "insert into API2_ENSEIGNANT(matricule,nom,prenom,tel,chargesem,salairemenu,dateengag) values(?,?,?,?,?,?,?)";
        String query2 = "select id_enseignant from API2_CLASSE where matricule= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,enseignant.getMatricule());
            pstm1.setString(2,enseignant.getNom());
            pstm1.setString(3,enseignant.getPrenom());
            pstm1.setString(4,enseignant.getTel());
            pstm1.setInt(5,enseignant.getChargeSem());
            pstm1.setDouble(6,enseignant.getSalaireMensu());
            LocalDate d1 = enseignant.getDateEngag();
            pstm1.setDate(7, Date.valueOf(d1)); //intelij m'a proposé cela comme solution car
            // si je mettais uniqement (7,d1) cela ne fonctionnais pas et je ne trouvais pas de solution

            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setInt(1,enseignant.getIdEnseignant());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int idEnseignant= rs.getInt(1);
                    enseignant.setIdEnseignant(idEnseignant);
                    notifyObservers();
                    return enseignant;
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
    public boolean removeEnseignant(Enseignant enseignant) {
        String query = "delete from API2_ENSEIGNANT where id_enseignant = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,enseignant.getIdEnseignant());
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
    public Enseignant updateEnseignant(Enseignant enseignant) {
        String query = "update API2_ENSEIGNANT set matricule =?,nom=?,prenom=?, tel=?, chargesem=?, salairemensu = ?, dateengag= ? where id_enseignant = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, enseignant.getMatricule());
            pstm.setString(2,enseignant.getNom());
            pstm.setString(3, enseignant.getPrenom());
            pstm.setString(4,enseignant.getTel());
            pstm.setInt(5,enseignant.getChargeSem());
            pstm.setDouble(6,enseignant.getSalaireMensu());
            LocalDate d1 = enseignant.getDateEngag();
            pstm.setDate(7, Date.valueOf(d1)); // j'ai refais pareil que dans la methode addEnseignant
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return readEnseignant(enseignant.getIdEnseignant());
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public Enseignant readEnseignant (int id_enseignant) {
        String query = "select * from API2_ENSEIGNANT where id_enseignant = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_enseignant);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String tel = rs.getString(5);
                int chargesem = rs.getInt(6);
                double salairemensu = rs.getDouble(7);
                LocalDate dateengag = rs.getDate(8).toLocalDate(); // j'ai eu bcp de complication avec localDta j'ai donc fais une demande sur chatGPT
                Enseignant e = new Enseignant(id_enseignant, matricule, nom, prenom, tel, chargesem, salairemensu, dateengag);
                return e;

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
    public List<Enseignant> getEnseignant() {
        List<Enseignant> es = new ArrayList<>();
        String query="select * from API2_ENSEIGNANT";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_enseignant = rs.getInt(1);
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String tel = rs.getString(5);
                int chargeSem = rs.getInt(6);
                double salairemensu = rs.getDouble(7);
                LocalDate dateengag = rs.getDate(8).toLocalDate();
                Enseignant ens = new Enseignant(id_enseignant, matricule, nom, prenom, tel, chargeSem, salairemensu, dateengag);
                es.add(ens);
            }
            return es;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public List getNotification() {
        return getEnseignant();
    }
}
