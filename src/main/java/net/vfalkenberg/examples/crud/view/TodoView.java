package net.vfalkenberg.examples.crud.view;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.apache.tomcat.jni.Local;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class TodoView {

    @NotNull(message = "todo.validation.id.not-null")
    private UUID id;

    @NotNull(message = "todo.validation.planned-time.not-null")
    private LocalDateTime plannedTime;

    @NotBlank(message = "todo.validation.name.not-blank")
    private String name;

    private LocalDateTime comletedPlannedDateTime;
}
