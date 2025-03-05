package com.example.todoapp.controllers;

import com.example.todoapp.model.TodoItem;
import com.example.todoapp.repositories.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoController implements CommandLineRunner {

    private final TodoItemRepository todoItemRepository;

    public TodoController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    String index(Model model) {

        List<TodoItem> todoItems = todoItemRepository.findAll();


        model.addAttribute("todoItems", todoItems);

        return "index";
    }

    @Override
    public void run(String... args) throws Exception {

        todoItemRepository.save(new TodoItem("Дэмо задача 1"));
        todoItemRepository.save(new TodoItem("Дэмо задача 2"));

    }
}