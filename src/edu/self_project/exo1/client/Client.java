package edu.self_project.exo1.client;

import edu.self_project.exo1.Constants;
import edu.self_project.exo1.communication.Communication;
import edu.self_project.exo1.communication.Target;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private String host;
    private int port;

    public Client() {
        host = Constants.HOST;
        port = Constants.PORT;
        System.out.println("test");
    }

    public Object request() {
        try (
                Socket socket = new Socket(host, port);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())
        ) {
            oos.writeObject(
                    new Communication("test", Target.STUDENT, "je suis un test", true)
            );
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
