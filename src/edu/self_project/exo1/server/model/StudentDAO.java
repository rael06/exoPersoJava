package edu.self_project.exo1.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO extends Connection {

    public ResultSet getAll() {
        String query = "SELECT id, name FROM students";
        try {
            return conn.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
