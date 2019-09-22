package edu.self_project.exo1.server.model.Entities;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
    }

    public void readObject(ObjectInputStream in) throws IOException {
        id = in.readInt();
        name = in.readUTF();
    }
}
