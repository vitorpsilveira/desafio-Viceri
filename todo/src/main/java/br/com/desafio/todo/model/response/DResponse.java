package br.com.desafio.todo.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DResponse<T> {

    private Integer code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static DResponse<Object> ok() {
        return new DResponse<Object>(0, "Success", null);
    }

    public static DResponse<Object> toDoNotFound() { return new DResponse<Object>(0, "Tarefa não enconstrada.", null);
    }
}
