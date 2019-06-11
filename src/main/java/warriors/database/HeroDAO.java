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
     * @param  hero AbstractHero
     * @return
     */
    public ResultSet getHero(AbstractHero hero){
        Statement stmt;
        ResultSet rs;
        //Read ConnexionManager
        try {
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Hero WHERE ID=" + hero.getId());
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
     * @param  hero AbstractHero
     */
    public void deleteHero(AbstractHero hero){
        Statement stmt;

        try {
            stmt = this.connection.createStatement();
            stmt.executeUpdate("DELETE FROM Hero WHERE ID =" + hero.getId());

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }


    /**
     *
     * @param  hero AbstractHero
     *
     */
    //TODO hero.getId() implementation !!!

    public void updateHero(AbstractHero hero){
        Statement stmt;
        String builder="UPDATE Hero  SET";

        builder += " Name ='" +  hero.getName() + "hello',";
        builder += " Life =" +  hero.getLife() + ",";

        builder += " Strengh =" +  hero.getAttackLevel() +"," ;
        builder += " Offense ='{\"name\":\"" +  hero.getEquipment().getName() +"\",\"Strengh\":"+hero.getEquipment().getAttackBonus()  + "}'" ;

        builder += " WHERE ID=" + hero.getId(); // hero.getId() implementation !!!
        System.out.println(builder);


        //Update to ConnexionManager
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(builder);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }

}
