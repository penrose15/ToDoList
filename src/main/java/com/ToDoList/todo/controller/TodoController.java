package com.ToDoList.todo.controller;

import com.ToDoList.todo.entity.Todo;
import com.ToDoList.todo.service.TodoService;
import com.ToDoList.todo.dto.PatchTodoDto;
import com.ToDoList.todo.dto.PostTodoDto;
import com.ToDoList.todo.dto.ResponseTodoDto;
import com.ToDoList.todo.mapper.TodoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }
    //todo 생성
    @PostMapping
    public ResponseEntity createTodo(@RequestBody @Valid PostTodoDto postTodoDto) {
        Todo todo = todoService.create(mapper.postTodoDtoToTodo(postTodoDto));
        return new ResponseEntity<>(mapper.todoToResponseTodoDto(todo),HttpStatus.CREATED);
    }
    //todo 수정
    @PatchMapping("/{todo-id}")
    public ResponseEntity updateTodo(@PathVariable("todo-id") @Positive Long todoId,
                                     @RequestBody @Valid PatchTodoDto patchTodoDto) {

        patchTodoDto.setTodoId(todoId);
        Todo todo = todoService.update(mapper.patchTodoDtoToTodo(patchTodoDto));
        return new ResponseEntity<>(mapper.todoToResponseTodoDto(todo),HttpStatus.OK);
    }
    //todo 조회
    @GetMapping("/{todo-id}")
    public ResponseEntity getTodoById(@PathVariable("todo-id") @Positive Long todoId) {
        Todo todo = todoService.findTodoById(todoId);
        return new ResponseEntity<>(mapper.todoToResponseTodoDto(todo), HttpStatus.OK);
    }
    //전체 todoList 조회
    @GetMapping
    public ResponseEntity getToDoList() {
        List<Todo> list= todoService.findAll();
        return new ResponseEntity<>(mapper.todoToResponseTodoDtos(list), HttpStatus.OK);
    }
    //todo 삭제
    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") @Positive Long todoId) {
        todoService.delete(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/status")
    public ResponseEntity categorize() {
        List<Todo> todoList = todoService.findByStatusTodo();
        List<Todo> doingList = todoService.findByStatusDoing();
        List<Todo> doneList = todoService.findByStatusDone();

        List<List<ResponseTodoDto>> list =
                List.of(mapper.todoToResponseTodoDtos(todoList),
                mapper.todoToResponseTodoDtos(doingList),
                mapper.todoToResponseTodoDtos(doneList));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
