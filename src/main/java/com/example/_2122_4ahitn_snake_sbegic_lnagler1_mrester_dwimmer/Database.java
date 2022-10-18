package htl.steyr.htlsteyr_4ahitn_gr2_jdbcview.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private String host = "xserv";
    private String user = "reader";
    private String db = "pagila";
    private String password = "reader";
    private String driverType = "postgresql";
    private int port = 5432;

    private static Connection connection = null;


    private Database() {
        try {
            Connection c =
                    DriverManager.getConnection(
                            "jdbc:" + driverType + "://" + host + ":" + port + "/" + db,
                            user,
                            password
                    );

            connection = c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            new Database();
        }

        return connection;
    }

}
