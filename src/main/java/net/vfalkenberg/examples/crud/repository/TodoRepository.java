package net.vfalkenberg.examples.crud.repository;

import net.vfalkenberg.examples.crud.entity.Todo;
import net.vfalkenberg.examples.crud.view.TodoView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
    Optional<Todo> findById(UUID uuid);
    Page<TodoView> findCompletedAll(Pageable pageable);
}
