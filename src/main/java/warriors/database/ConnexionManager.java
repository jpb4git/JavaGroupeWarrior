package warriors.database;

import java.sql.*;

public class ConnexionManager {

    private Connection connection;



    public ConnexionManager() {

        try {
            this.connection =
                    DriverManager.getConnection("jdbc:mysql://217.182.141.113/CampusNumerique2020?" +
                            "user=CampusNumerique2020&password=CampusNumerique2020");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }


    public Connection getConnection() {
        return connection;
    }
}
