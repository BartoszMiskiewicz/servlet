package com.sda.sockets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * podlaczamy sie do serwera
 */
public class Client {

    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("localhost", 1234); - lokalnie
        //do danego uzytkownika pod IP
        Socket socket = new Socket("192.168.100.106", 1234);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(socket.getInputStream());
        Scanner scannerToUser = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            writer.write(scannerToUser.nextLine() + "\n");
            writer.flush();
            System.out.println("Guest:" + scanner.nextLine());
        }


        socket.close();
    }
}
