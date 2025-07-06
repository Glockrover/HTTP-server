package org.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Server {

    public static void main(String[] args) {
        try {

            // Creating a new serverSocket object
            ServerSocket serverSocket = new ServerSocket(4221);

            serverSocket.setReuseAddress(true);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.example.com"))
                    .build();
            serverSocket.accept();
            System.out.println("accepted new connection");

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Access and print response details
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Headers: " + response.headers());
            System.out.println("Body: " + response.body());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}