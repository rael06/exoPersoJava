package edu.self_project.exo1.server;

import edu.self_project.exo1.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        do {
            try (ServerSocket serverSocket = new ServerSocket(Constants.PORT)) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new Service(socket));
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
