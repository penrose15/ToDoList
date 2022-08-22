package com.ToDoList.todo.dto;


import com.ToDoList.todo.Status;

import com.ToDoList.todo.Todo;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
public class PostTodoDto {


    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @Range(min = 1, max = 3)
    private int importance;


    private Status status;

}
