package com.ToDoList.user.entity;

import com.ToDoList.audit.Auditable;
import com.ToDoList.todo.entity.Todo;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Table(name = "users")
@Entity
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false ,unique = true)
    private String email;

    @Column(nullable = false)
    private Role role = Role.USER;

    @OneToMany(mappedBy = "user")
    private List<Todo> todoList = new ArrayList<>();

    public void addTodo(Todo todo) {
        todoList.add(todo);
        if(todo.getUser() != this) {
            todo.setUser(this);
        }
    }

    public enum Role {
        USER,
        MANAGER,
        ADMIN;
    }

}
