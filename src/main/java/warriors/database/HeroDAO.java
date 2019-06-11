package warriors.database;

import warriors.heroes.AbstractHero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HeroDAO {

    private Connection connection;

    /**
     *
     * @param connection
     */
    public HeroDAO(Connection connection ) {
        this.connection = connection;
    }

    /**
     *
     * @param id
     * @return
     */
    public ResultSet getHero(int id){
        Statement stmt;
        ResultSet rs;
        //Read ConnexionManager
        try {
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Hero WHERE ID=" + id);
            return rs;


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return  null;

    }

    /**
     *
     * @return
     */
    public ResultSet getHeroes(){
        Statement stmt = null;
        ResultSet rs = null;
        //Read ConnexionManager
        try {
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Hero");
            return rs;
            /*while (rs.next()) {
                String name = rs.getString("Name");
                System.out.println(name);
            }
            rs.next();
            System.out.println(rs.getString(("Name")));

             */

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return  null;
    }

    /**
     *
     * @param id
     */
    public void deleteHero(int id){
        Statement stmt;

        try {
            stmt = this.connection.createStatement();
            stmt.executeUpdate("DELETE FROM Hero WHERE ID ="+ id);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     *
     * @param id
     * @param params
     */
    //TODO hero.getId() implementation !!!

    public void updateHero(int id , AbstractHero hero){
        Statement stmt;
        String builder="UPDATE Hero  SET";

        builder += "Name = " +  hero.getName() + ",";
        builder += "Life = " +  hero.getLife() + ",";

        builder += "Strengh = " +  hero.getAttackLevel()  ;
        builder += "WHERE ID =" + id; // hero.getId() implementation !!!



        //Update to ConnexionManager
        try {
            stmt = conn.createStatement();
            int update = stmt.executeUpdate(" UPDATE Hero  SET Name = "+hero. +", Life = 18, Strengh = 2 WHERE ID ="+id);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }

}
