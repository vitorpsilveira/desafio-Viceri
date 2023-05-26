package br.com.desafio.todo.model.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ToDoResponse {
    private Long id;
    private String toDo;
    private String priority;
    private String status;
    private String user;
}
