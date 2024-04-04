package DB;

import Ecole.metier.Classe;
import myconnections.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class Gestion {

    /**
     * author Noah Vaccarello
     */

        private Scanner sc = new Scanner(System.in);
        private Connection dbConnect;

        public void gestion() {
            dbConnect = DBConnection.getConnection();
            if (dbConnect == null) {
                System.exit(1);
            }
            System.out.println("connexion établie");
            do {
                System.out.println("1.ajout\n2.recherche\n3.modification\n4.suppression\n5.tous\n6.fin");
                System.out.println("choix : ");
                int ch = sc.nextInt();
                sc.skip("\n");
                switch (ch) {
                    case 1:
                        ajout();
                        break;
                    case 2:
                        recherche();
                        break;
                    case 3:
                        modification();
                        break;
                    case 4:
                        suppression();
                        break;
                    case 5:
                        tous();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("choix invalide recommencez ");
                }
            } while (true);
        }

        public void ajout() {

            System.out.print("Sigle de la classe :");
            String sigle = sc.nextLine();
            System.out.print("Année :");
            int annee = sc.nextInt();
            System.out.print("Specialite :");
            String specialite = sc.next();
            System.out.print("Nombre d'élève :");
            int nbreEleves = sc.nextInt();
            String query1 = "insert into API2_CLASSE(sigle,annee,specialite,nbreEleves) values(?,?,?,?)";
            String query2 = "select id_classe from API2_CLASSE where sigle= ?";
            try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
                PreparedStatement pstm2= dbConnect.prepareStatement(query2);
            ){
                pstm1.setString(1,sigle);
                pstm1.setInt(2,annee);
                pstm1.setString(3,specialite);
                pstm1.setInt(4,nbreEleves);
                int n = pstm1.executeUpdate();
                System.out.println(n+" ligne insérée");
                if(n==1){
                    pstm2.setString(1,sigle);
                    ResultSet rs= pstm2.executeQuery();
                    if(rs.next()){
                        int idclasse= rs.getInt(1);
                        System.out.println("idclasse = "+idclasse);
                    }
                    else System.out.println("record introuvable");
                }

            } catch (SQLException e) {
                System.out.println("erreur sql :"+e);
            }
        }


        public void recherche() {

            System.out.println("id de la classe recherché ");
            int idrech = sc.nextInt();
            String query = "select * from API2_CLASSE where id_classe = ?";
            try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1,idrech);
                ResultSet rs = pstm.executeQuery();
                if(rs.next()){
                    String sigle = rs.getString(2);
                    int annee = rs.getInt(3);
                    String specialite = rs.getString(4);
                    int nbreEleves  = rs.getInt(5);
                    Classe cl = new Classe(idrech,sigle,annee,specialite,nbreEleves);
                    System.out.println(cl);
                }
                else System.out.println("record introuvable");
            } catch (SQLException e) {
                System.out.println("erreur sql :"+e);
            }

        }

        public void modification() {
            System.out.println("id de la classe recherchée ");
            int idrech = sc.nextInt();
            sc.skip("\n");
            System.out.println("nouveau sigle : ");
            String sigle = sc.nextLine();
            String query = "update API2_CLASSE set sigle=? where id_classe = ?";
            try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setString(1,sigle);
                pstm.setInt(2,idrech);
                int n = pstm.executeUpdate();
                if(n!=0) System.out.println(n+ "ligne mise à jour");
                else System.out.println("record introuvable");

            } catch (SQLException e) {
                System.out.println("erreur sql :" + e);
            }
        }
        public void suppression() {
            System.out.println("id de la classe recherchée ");
            int idrech = sc.nextInt();
            String query = "delete from API2_CLASSE where id_classe = ?";
            try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1,idrech);
                int n = pstm.executeUpdate();
                if(n!=0) System.out.println(n+ "ligne supprimée");
                else System.out.println("record introuvable");

            } catch (SQLException e) {
                System.out.println("erreur sql :"+e);
            }
        }

    private void tous() {
        String query="select * from API2_CLASSE";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int idrech = rs.getInt(1);
                String sigle = rs.getString(2);
                int annee = rs.getInt(3);
                String specialite = rs.getString(4);
                int nbreEleves  = rs.getInt(5);
                Classe cl = new Classe(idrech,sigle,annee,specialite,nbreEleves);
                System.out.println(cl);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }

    public static void main(String[] args) {
        Gestion g = new Gestion();
        g.gestion();
    }
}
