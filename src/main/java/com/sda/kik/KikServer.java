package com.sda.kik;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 */
//x
public class KikServer {
    public static void main(String[] args) throws IOException{

        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();

        //board pokazuje plansze
        Scanner scanner = new Scanner(System.in);

        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner socketIn = new Scanner(socket.getInputStream());

        Board board = new Board();
        //zaczynamy cala gre
        boolean flag = true;
        System.out.println("You'r first");
        while (!board.isGameFinished()) {
            System.out.println(board);
            if (board.getCounter() % 2 ==0) {
                yourTurn(scanner, socketOut, board);
            }else {
                oponentsTurn(socketIn, board);
            }
        }
    }

    private static void oponentsTurn(Scanner socketIn, Board board) {
        String oponentPosition = socketIn.nextLine();
        board.addMove(Integer.valueOf(oponentPosition), "O");
    }

    private static void yourTurn(Scanner scanner, BufferedWriter socketOut, Board board) throws IOException {
        boolean status;
        System.out.println(board.toString());
        do {
            System.out.println("Instert position: ");
            String number = scanner.nextLine();
            status = board.addMove(Integer.valueOf(number), "X");
            if (status) {
                socketOut.write(number + "\n");
                socketOut.flush();
            } else {
                System.out.println("Invalid position");
            }
        } while (!status);
    }
}
