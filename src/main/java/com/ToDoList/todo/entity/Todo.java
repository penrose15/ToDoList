package com.ToDoList.todo.entity;

import com.ToDoList.audit.Auditable;

import com.ToDoList.todo.status.Status;
import lombok.*;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter

@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Todo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private int importance;
    //우선순위

    @Enumerated(value = EnumType.STRING)
    private Status status;
    //TODO, DOING, DONE


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}