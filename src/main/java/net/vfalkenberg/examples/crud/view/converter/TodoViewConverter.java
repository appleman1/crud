package net.vfalkenberg.examples.crud.view.converter;

import net.vfalkenberg.examples.crud.entity.Todo;
import net.vfalkenberg.examples.crud.view.TodoView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class TodoViewConverter implements ViewConverter<Todo,TodoView>{


    @Override
    public TodoView toView(Todo todo) {
        return new TodoView().setId(todo.getId()).setName(todo.getName()).setPlannedTime(todo.getPlannedTime());
    }

    @Override
    public Todo toEntity(TodoView view) {
        return new Todo().setId(view.getId()).setName(view.getName()).setPlannedTime(view.getPlannedTime());
    }
}
