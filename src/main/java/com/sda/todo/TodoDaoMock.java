package com.sda.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoMock implements TodoDao {

    private List<TodoModel> todos;

    public TodoDaoMock() {
        todos = new ArrayList<>();
        init();
    }

    @Override
    public List<TodoModel> getAllTodos() {
        return todos;
    }

    @Override
    public void addTodo(TodoModel todoModel) {
        todos.add(todoModel);
    }

    private void init() {
        todos.add(new TodoModel("Zadanie Domowe", "Do zrobienia mam zadanie 1 ze strony 10", false, 5, LocalDate.now()));
        todos.add(new TodoModel("Spotkanie z Tomkiem", "Idziemy na kregle", false, 3, LocalDate.now().minusDays(5)));
        todos.add(new TodoModel("Zakupy", "2 pomarancze, kilogram ziemniakow, chipsy i cola", false, 5, LocalDate.now().plusDays(7)));
    }
}
