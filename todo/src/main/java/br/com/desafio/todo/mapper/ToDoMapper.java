package br.com.desafio.todo.mapper;

import br.com.desafio.todo.model.EToDo;
import br.com.desafio.todo.model.EUser;
import br.com.desafio.todo.model.request.ToDoRequest;
import br.com.desafio.todo.model.response.ToDoResponse;
import br.com.desafio.todo.repository.UserRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoMapper {

    default EToDo toDoRequestToEToDo(ToDoRequest request, EUser user) {

        return EToDo.builder()
                .toDo(request.getToDo())
                .priority(request.getPriority())
                .status(request.getStatus())
                .user(user)
                .build();
    }

    default ToDoResponse eToDotoToDoResponse(EToDo toDo){
        return ToDoResponse.builder()
                .id(toDo.getId())
                .toDo(toDo.getToDo())
                .priority(toDo.getPriority().getPriority())
                .status(toDo.getStatus().getStatus())
                .user(toDo.getUser().getName())
                .build();
    };

    List<ToDoResponse> eToDoListToDoResponseList(List<EToDo> toDo);
}
