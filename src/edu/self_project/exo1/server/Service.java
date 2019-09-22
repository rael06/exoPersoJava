package edu.self_project.exo1.server;

import edu.self_project.exo1.communication.Communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class Service implements Runnable {
    private Socket socket;

    Service(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            System.out.println("connecté");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object request = ois.readObject();
            System.out.println("test" + ((Communication) request).getType());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
