package edu.self_project.exo1.server.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
    private static Connection connection;
    private String password = "";
    private String userName = "root";
    private String databaseName = "classes_exo_perso_java";
    private String url = "jdbc:mysql://localhost:3306/" + this.databaseName +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private Database() {
        try {
            Database.connection =
                    DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (connection == null) new Database();
        return connection;
    }
}
