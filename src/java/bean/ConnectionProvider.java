//This class manages all the connection process related to connection with database
package bean;

import java.sql.*;

public class ConnectionProvider {

    static Connection con = null;

    public static Connection getCon() {

        try {

            try {
                Class.forName("com.ibm.db2.jcc.DB2Driver");

            } catch (ClassNotFoundException ex) {

                ex.printStackTrace();
            }
            con = DriverManager.getConnection("jdbc:db2://" + "localhost:50000/lnms", "dksh", "deep");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return con;
    }

}
