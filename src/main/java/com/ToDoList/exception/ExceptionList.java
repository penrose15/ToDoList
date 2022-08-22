package com.ToDoList.exception;

import lombok.Getter;

//exception 목록
public enum ExceptionList {

    TODO_NOT_FOUND(404, "Todo Not Found"),
    TODO_ALREADY_EXIST(400, "Todo Already Exist");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionList(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
