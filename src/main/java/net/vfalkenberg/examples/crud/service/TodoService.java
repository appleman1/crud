package net.vfalkenberg.examples.crud.service;

import net.vfalkenberg.examples.crud.view.TodoView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface TodoService {
    Page<TodoView> findAll(Pageable pageable);

    Optional<TodoView> findOne(UUID uuid);

    TodoView save(TodoView todoView);

    Page<TodoView> findCompletedAll(Pageable pageable);
}
