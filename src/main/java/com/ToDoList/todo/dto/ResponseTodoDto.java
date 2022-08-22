package com.ToDoList.todo.dto;

import com.ToDoList.todo.Status;
import com.ToDoList.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
