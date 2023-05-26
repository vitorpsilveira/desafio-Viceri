package br.com.desafio.todo.service;

import br.com.desafio.todo.mapper.ToDoMapper;
import br.com.desafio.todo.model.EToDo;
import br.com.desafio.todo.model.Status;
import br.com.desafio.todo.model.request.ToDoRequest;
import br.com.desafio.todo.model.response.ToDoResponse;
import br.com.desafio.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ToDoService {

    private final ToDoMapper toDoMapper;
    private final UserService userService;
    private final ToDoRepository toDoRepository;

    public EToDo findByIdAndUserId(Long id, Integer user) {
        return toDoRepository.findByIdAndUserId(id, user);
    }

    public boolean deleteByIdAndUser(Long id, Integer user) {
        EToDo eToDo = findByIdAndUserId(id, user);
        if (eToDo == null) {
            return false;
        }
        toDoRepository.delete(eToDo);
        return true;
    }

    public ToDoResponse save(ToDoRequest newToDo) {

        EToDo toDo = toDoMapper.toDoRequestToEToDo(newToDo,
                userService.findById(newToDo.getUserId()));

        return toDoMapper.eToDotoToDoResponse(toDoRepository.save(toDo));
    }

    public ToDoResponse update(Long id, ToDoRequest updatedToDo) {

        EToDo toDo = toDoMapper.toDoRequestToEToDo(updatedToDo,
                userService.findById(updatedToDo.getUserId()));
        toDo.setId(id);

        return toDoMapper.eToDotoToDoResponse(toDoRepository.save(toDo));
    }

    public ToDoResponse conclude(Long id, Integer user) {
        EToDo toDo = toDoRepository.findByIdAndUserId(id, user);
        toDo.setStatus(Status.CONCLUIDA);

        return toDoMapper.eToDotoToDoResponse(toDoRepository.save(toDo));
    }

    public List<ToDoResponse> listPendencies(String priorities) {

        if(priorities != null){
            List<EToDo> toDoList =
                    toDoRepository.findByStatusAndPriority(String.valueOf(Status.PENDENTE),
                            priorities.toUpperCase());
            return toDoMapper.eToDoListToDoResponseList(toDoList);
        }

        List<EToDo> toDoList = toDoRepository.findByStatus(String.valueOf(Status.PENDENTE));

        return toDoMapper.eToDoListToDoResponseList(toDoList);
    }
}
