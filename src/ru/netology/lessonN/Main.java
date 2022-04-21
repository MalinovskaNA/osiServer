package ru.netology.lessonN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8089;

        ServerSocket serverSocket = new ServerSocket(port); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
        while (true) {
            Socket clientSocket = serverSocket.accept(); // ждем подключения

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());
            System.out.printf("New connection accepted.");

            out.println(String.format("Hi, write your name", clientSocket.getPort()));

            String name = in.readLine();

            out.println(String.format("%s, are you child?", name, clientSocket.getPort()));

            String answer = in.readLine();

            if (answer.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name, clientSocket.getPort()));
            } else if (answer.equals("no")) {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name, clientSocket.getPort()));
            } else {
                out.println(String.format("%s, your answer is not correct!", name, clientSocket.getPort()));
            }
        }
    }
}
