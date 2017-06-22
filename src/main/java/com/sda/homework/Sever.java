package com.sda.homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by bartosz on 21.06.2017.
 */
public class Sever {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        boolean flag = true;
        while (flag) {
            Socket socket = serverSocket.accept();


            // dostaje za pomoca socket 5 liczba
            // sumuje je
            //oddaje sume
            //* w petli



            Scanner scanner = new Scanner(socket.getInputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            int sum = 0;
            for (int i = 0; i < 5; i++) {
                String input = scanner.nextLine();
                Integer integer = Integer.valueOf(input);
                System.out.println("Received number: " + input);
                sum += integer;

            }

            writer.write(sum + "\n");
            writer.flush();
            System.out.println("Finishing connection");
            socket.close();
        }


        serverSocket.close();
    }
}


