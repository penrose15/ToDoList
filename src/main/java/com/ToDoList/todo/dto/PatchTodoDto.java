package com.ToDoList.todo.dto;

import com.ToDoList.todo.Todo;
import com.ToDoList.validator.NotSpace;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class PatchTodoDto {

    private Long todoId;

    @NotSpace
    private String title;

    @NotSpace
    private String content;

    @Range(min = 1, max = 3)
    private int importance;

    private Todo.Status status;

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }
}
