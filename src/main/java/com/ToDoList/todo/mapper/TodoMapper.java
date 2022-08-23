package com.ToDoList.todo.mapper;

import com.ToDoList.todo.entity.Todo;
import com.ToDoList.todo.dto.PatchTodoDto;
import com.ToDoList.todo.dto.PostTodoDto;
import com.ToDoList.todo.dto.ResponseTodoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    Todo postTodoDtoToTodo(PostTodoDto postTodoDto);

    Todo patchTodoDtoToTodo(PatchTodoDto patchTodoDto);

    ResponseTodoDto todoToResponseTodoDto(Todo todo);

    List<ResponseTodoDto> todoToResponseTodoDtos(List<Todo> todoList);
}
