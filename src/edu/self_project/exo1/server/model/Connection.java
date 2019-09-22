package edu.self_project.exo1.server.model;

abstract class Connection {
    protected java.sql.Connection conn = Database.getInstance();
}
