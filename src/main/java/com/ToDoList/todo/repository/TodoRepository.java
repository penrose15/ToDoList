package com.ToDoList.todo.repository;

import com.ToDoList.todo.status.Status;
import com.ToDoList.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByStatus(Status status);


    default List<Todo> findByStatusIsTodo() {
        return findByStatus(Status.TODO);
    }


    default List<Todo> findByStatusIsDoing() {
        return findByStatus(Status.DOING);
    }


    default List<Todo> findByStatusIsDone() {
        return findByStatus(Status.DONE);
    }


}
