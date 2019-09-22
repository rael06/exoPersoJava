package edu.self_project.exo1.server.model.DAO;

import edu.self_project.exo1.server.model.Entities.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends abstractDAO {



    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();

        String query = "SELECT id, name FROM students";
        try {
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
