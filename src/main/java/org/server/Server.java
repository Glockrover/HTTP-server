package org.server;

import java.io.IOException;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        // You can use print statements as follows for debugging, they'll be visible when running tests.
        System.out.println("Logs from your program will appear here!");

//     Uncomment this block to pass the first stage
        try {
            ServerSocket serverSocket = new ServerSocket(4221);

            // Since the tester restarts your program quite often, setting SO_REUSEADDR
            // ensures that we don't run into 'Address already in use' errors
            serverSocket.setReuseAddress(true);

            Socket clientSocket = serverSocket.accept(); // Wait for connection from client.
            System.out.println("accepted new connection");

            // Write HTTP 200 OK response to client
            OutputStream outputStream = clientSocket.getOutputStream();
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n";
            outputStream.write(httpResponse.getBytes());

            // Close streams and sockets
            outputStream.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
