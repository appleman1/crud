package net.vfalkenberg.examples.crud.service;

import net.vfalkenberg.examples.crud.entity.Todo;
import net.vfalkenberg.examples.crud.exception.UnknownPersistenseException;
import net.vfalkenberg.examples.crud.repository.TodoRepository;
import net.vfalkenberg.examples.crud.view.TodoView;
import net.vfalkenberg.examples.crud.view.converter.ViewConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final ViewConverter<Todo, TodoView> viewConverter;

    public TodoServiceImpl(TodoRepository todoRepository, ViewConverter<Todo, TodoView> viewConverter) {
        this.todoRepository = requireNonNull(todoRepository);
        this.viewConverter = requireNonNull(viewConverter);
    }

    @Override
    public Page<TodoView> findAll(Pageable pageable) {
        try {
            return todoRepository.findAll(pageable).map(viewConverter::toView);
        } catch (PersistenceException ex) {
            throw new UnknownPersistenseException(ex);
        }
    }

    @Override
    public Optional<TodoView> findOne(UUID uuid) {
        try {
            return todoRepository.findById(uuid).map(viewConverter::toView);
        }catch (PersistenceException e){
            throw  new UnknownPersistenseException(e);
        }
    }
    @Override
    public TodoView save(TodoView todoView){
        Todo todo = viewConverter.toEntity(todoView);
        Todo savedTodo = todoRepository.save(todo);
        return viewConverter.toView(savedTodo);
    }
    @Override
    public Page<TodoView> findCompletedAll (Pageable pageable){
        try {
          return todoRepository.findCompletedAll(pageable).map(entity -> {
              if (!entity.getComletedPlannedDateTime().equals(null)){
               return viewConverter.toView(todoRepository.getOne(entity.getId()));
              }else return null;
           });
        }catch (PersistenceException e){
            throw  new UnknownPersistenseException(e);
        }
    }

}
