package com.ToDoList.todo.sequence;

import lombok.Getter;

public enum Sequence {
    IMPORTANCE_ORDER("1"),
    TITLE_ALPHABETICAL_ORDER("2"),
    CREATED_AT("3");

    @Getter
    private String value;

    Sequence(String value) {
        this.value = value;
    }
}
