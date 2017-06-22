package com.sda.kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by bartosz on 21.06.2017.
 */
public class KikClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);


        Scanner scanner = new Scanner(System.in);


        Scanner socketIn = new Scanner(socket.getInputStream());
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Board board = new Board();
        System.out.println("Waiting for first move");
        while (!board.isGameFinished()) {
            System.out.println(board);
            if(board.getCounter() % 2 ==0) {
            oponentsTurn(socketIn, board);
        } else {
                yourTurn(scanner, socketOut, board);
            }
        }
    }

    private static void yourTurn(Scanner scanner, BufferedWriter socketOut, Board board) throws IOException {
        boolean status;
        do {
            System.out.println("Insert position: ");
            String outPosition = scanner.nextLine();
            Integer outPositionNumber = Integer.valueOf(outPosition);
            status = board.addMove(outPositionNumber, "O");
            if (status) {
                socketOut.write(outPositionNumber + "\n");
                socketOut.flush();
            } else {
                System.out.println("Invalid position");
            }
        } while (!status);
    }

    private static void oponentsTurn(Scanner socketIn, Board board) {
        String oponentPosition = socketIn.nextLine();
        Integer position = Integer.valueOf(oponentPosition);
        board.addMove(position, "X");
    }
}
