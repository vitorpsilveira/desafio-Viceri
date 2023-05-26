package br.com.desafio.todo.model.request;

import br.com.desafio.todo.model.EUser;
import br.com.desafio.todo.model.Priority;
import br.com.desafio.todo.model.Status;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ToDoRequest {
    private String toDo;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Integer userId;
}
