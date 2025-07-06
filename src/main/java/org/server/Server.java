package org.server;


import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {
        try {
            // Creating a new serverSocket object
            ServerSocket serverSocket = new ServerSocket(4221);

            serverSocket.setReuseAddress(true);

            serverSocket.accept();
            System.out.println("accepted new connection");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}