package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8081), 0
        );

        server.createContext("/", exchange -> {
            String response = "Hello from Jenkins + Docker CI/CD - Version 1.0.3!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        server.start();

        System.out.println("Application started on port 8081");
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
