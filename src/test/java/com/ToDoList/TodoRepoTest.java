package com.ToDoList;

import com.ToDoList.todo.status.Status;
import com.ToDoList.todo.entity.Todo;
import com.ToDoList.todo.repository.TodoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TodoRepoTest {

    @Autowired
    TodoRepository todoRepository;

    @Test
    @DisplayName("TodoRepository 테스트")
    void todoRepo() {
        Todo todo1 = new Todo(1L, "title1", "content1",1, Status.TODO);
        Todo todo2 = new Todo(2L, "title2", "content2",1, Status.DOING);
        Todo todo3 = new Todo(3L, "title3", "content3",1, Status.DONE);


        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);

        List<Todo> list1 = todoRepository.findByStatusIsTodo();
        List<Todo> list2 = todoRepository.findByStatusIsDoing();
        List<Todo> list3 = todoRepository.findByStatusIsDone();
        System.out.println(list1.get(0).getContent());
        assertThat(list1.get(0).getContent()).isEqualTo(todo1.getContent());
        assertThat(list2.get(0).getContent()).isEqualTo(todo2.getContent());
        assertThat(list3.get(0).getContent()).isEqualTo(todo3.getContent());
    }
}
