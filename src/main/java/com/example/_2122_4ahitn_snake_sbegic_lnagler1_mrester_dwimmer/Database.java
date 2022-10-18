package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.scene.chart.PieChart;
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
    public static Connection connection = null;

    Database() {
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

}

    public static getConnection(){
        if ( connection == null){
            new Database();
        }
        return connection;
    }

}
