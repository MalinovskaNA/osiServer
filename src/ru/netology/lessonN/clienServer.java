package ru.netology.lessonN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clienServer {
    public static void main(String[] args) {
        String host = "netology.homework";
        //String host = "127.0.0.1";
        int port = 8089;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            String resp = in.readLine();
            System.out.println(resp);
            String name = scanner.nextLine();
            out.println(name);

            String resp2 = in.readLine();
            System.out.println(resp2);
            String answer = scanner.nextLine();
            out.println(answer);
            String resp3 = in.readLine();
            System.out.println(resp3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
