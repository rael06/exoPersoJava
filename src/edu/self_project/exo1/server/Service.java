package edu.self_project.exo1.server;

import edu.self_project.exo1.communication.Communication;
import edu.self_project.exo1.server.model.Entities.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

class Service implements Runnable {
    private Socket socket;

    Service(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object request = ois.readObject();

            Communication response =
                    new RequestManager((Communication) request).response;

            oos.writeObject(response);
            oos.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
