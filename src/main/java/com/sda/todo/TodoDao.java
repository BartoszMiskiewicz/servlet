package com.sda.todo;

import java.util.List;

public interface TodoDao {
    List<TodoModel> getAllTodos();

    void addTodo(TodoModel todoModel);

    //DAO to jest - date axes object
}
