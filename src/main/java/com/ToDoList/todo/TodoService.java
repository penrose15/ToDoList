package com.ToDoList.todo;

import com.ToDoList.exception.BusinessLogicException;
import com.ToDoList.exception.ExceptionList;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //todo 생성
    public Todo create(Todo todo) {
    
        return todoRepository.save(todo);
    }
    //todo 수정
    public Todo update(Todo todo) {
       Todo findTodo = verifyTodo(todo.getTodoId());
       Optional.ofNullable(todo.getTitle()).ifPresent(findTodo::setTitle);
       Optional.ofNullable(todo.getContent()).ifPresent(findTodo::setContent);
       Optional.ofNullable(todo.getStatus()).ifPresent(findTodo::setStatus);
       Optional.of(todo.getImportance()).ifPresent(findTodo::setImportance);

       return todoRepository.save(findTodo);
    }
    //todo id로 찾기
    public Todo findTodoById(Long todoId) {
        return verifyTodo(todoId);
    }
    //todo 리스트로 전체 조회
    public List<Todo> findAll() {
        List<Todo> todoList = todoRepository.findAll();
        if(todoList.isEmpty()) throw new BusinessLogicException(ExceptionList.TODO_NOT_FOUND);

        return todoList;
    }
    //todo 삭제
    public void delete(Long todoId) {
        verifyTodo(todoId);
        todoRepository.deleteById(todoId);
    }


    //Todo가 있는지 확인(있으면 예외처리)
    private void findTodo(Long todoId) {
        Optional<Todo> todo = todoRepository.findById(todoId);
        if(todo.isPresent()) throw new BusinessLogicException(ExceptionList.TODO_ALREADY_EXIST);
    }

    //Todo가 있는지 확인(없으면 예외처리)
    private Todo verifyTodo(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.orElseThrow(() ->new BusinessLogicException(ExceptionList.TODO_NOT_FOUND));
    }

    //Status별 조회
    private List<Todo> findByStatus(Status status) {
        List<Todo> list = todoRepository.findByStatus(status);

        return list;
    }

    public List<Todo> findByStatusTodo() {
        List<Todo> list = todoRepository.findByStatusIsTodo();
        return list;
    }
    public List<Todo> findByStatusDoing() {
        List<Todo> list = todoRepository.findByStatusIsDoing();
        return list;
    }
    public List<Todo> findByStatusDone() {
        List<Todo> list = todoRepository.findByStatusIsDone();
        return list;
    }

}
