package com.ToDoList.todo.status;

public enum Status{
    TODO("todo"),
    DOING("doing"),
    DONE("done");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getkey() {
        return name();
    }
    public String getValue() {
        return value;
    }
}
