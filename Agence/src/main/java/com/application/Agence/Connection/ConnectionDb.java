package com.application.Agence.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@org.springframework.context.annotation.Configuration
public class ConnectionDb {
    private final String url;
    private final String user;
    private final String password;


    public ConnectionDb() {
        this.url = "jdbc:postgresql://localhost:5432/" + Configuration.DatabaseName;
        this.user = Configuration.User;
        this.password = Configuration.Password;
    }

    public Connection createConnection() {
        try {
            return DriverManager.getConnection(
                    this.url, this.user, this.password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection connection;
    public static void AcquireConnection() {
        ConnectionDb Db = new ConnectionDb();
        connection = Db.createConnection();
    }

}
