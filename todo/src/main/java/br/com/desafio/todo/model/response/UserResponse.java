package br.com.desafio.todo.model.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private Integer id;
    private String name;
    private String email;

}
