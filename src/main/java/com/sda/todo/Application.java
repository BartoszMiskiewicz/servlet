package com.sda.todo;

import java.util.Scanner;

/**
 * Created by bartosz on 19.06.2017.
 */
public class Application {
    public static  void main (String[] args) {
        TodoDao todoDao = new TodoDaoMock();
        TodoView todoView = new TodoViewHtml();
        TodoChain todoChain = new TodoChain(todoView, todoDao);

        Scanner scanner = new Scanner(System.in);
        System.out.println("/all Wyswietl wszystkie");
        System.out.println("/add Dodaj");
        String answer = scanner.nextLine();

    }
}
