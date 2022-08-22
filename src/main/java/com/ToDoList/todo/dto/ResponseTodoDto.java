package com.ToDoList.todo.dto;

import com.ToDoList.todo.Todo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseTodoDto {

    private Long todoId;

    private String title;

    private String content;

    private int importance;

    private Todo.Status status;
}
