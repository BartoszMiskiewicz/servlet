package com.sda.sockets;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * server ktory przyjmuje cos z input stream
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Waiting for connection");
        Socket socket = serverSocket.accept();
        System.out.println("Connection established");

        Scanner scanner = new Scanner(socket.getInputStream());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String input = scanner.nextLine();
        System.out.println("Received message:" + input);
        writer.write(input + "pong\n");
        System.out.println("Flushing output");
        writer.flush();

        socket.close();
        serverSocket.close();
    }
}
