package edu.self_project.exo1.server.model.DAO;

import edu.self_project.exo1.server.model.Database;

import java.util.ArrayList;
import java.util.List;

abstract class abstractDAO {
    java.sql.Connection conn = Database.getInstance();
}
