package com.ToDoList.todo.dto;


import com.ToDoList.todo.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseTodoDto {

    private Long todoId;

    private String title;

    private String content;

    private int importance;

    private Status status;
}
