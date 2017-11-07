package net.vfalkenberg.examples.crud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "todo_list")
@Getter
@Setter
@Accessors(chain =  true)
public class Todo {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private UUID id;

    @Column(name = "planned_datetime")
    private LocalDateTime plannedTime;

    @Column(name = "name")
    private String name;

    @Column(name = "completed_planned_datetime")
    private LocalDateTime completedPlannedDateTime;

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        return id.equals(todo.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
