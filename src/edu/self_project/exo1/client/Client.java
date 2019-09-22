package edu.self_project.exo1.client;

import edu.self_project.exo1.Constants;
import edu.self_project.exo1.communication.Communication;
import edu.self_project.exo1.communication.ERequestType;
import edu.self_project.exo1.communication.ETarget;
import edu.self_project.exo1.server.model.Entities.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Client {

    private String host;
    private int port;

    public Client() {
        host = Constants.HOST;
        port = Constants.PORT;
    }

    public Object request(Communication request) {
        try (
                Socket socket = new Socket(host, port);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())
        ) {

            oos.writeObject(request);
            oos.flush();

            Communication response = (Communication) ois.readObject();
            if (response != null) {
                for (Student student : (List<Student>) response.getContent()){
                    System.out.println(student.getName());
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
