package com.ToDoList.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByStatus(Status status);

    List<Todo> findAllOrderByImportance();

    List<Todo> findAllOrderByTitle();

    List<Todo> findByStatusOrderByImportance(Status status);


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
