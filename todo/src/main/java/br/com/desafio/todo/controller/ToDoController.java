package br.com.desafio.todo.controller;

import br.com.desafio.todo.model.request.ToDoRequest;
import br.com.desafio.todo.model.response.DResponse;
import br.com.desafio.todo.model.Status;
import br.com.desafio.todo.model.Priority;
import br.com.desafio.todo.model.response.ToDoResponse;
import br.com.desafio.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/api/todo/")
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping("/save")
    public ResponseEntity<ToDoResponse> saveToDo(@RequestBody ToDoRequest toDo) {
        return ResponseEntity.ok(toDoService.save(toDo));
    }

    @DeleteMapping("/delete/{id}")
    public DResponse deleteToDo(@PathVariable Long id, Integer user){
        if(!toDoService.deleteByIdAndUser(id, user)) {
            return DResponse.toDoNotFound();
        }
        return DResponse.ok();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ToDoResponse> updateToDo(@PathVariable Long id,
                                                   @RequestBody ToDoRequest toDo){
        return ResponseEntity.ok(toDoService.update(id, toDo));
    }

    @PatchMapping("/conclude/{id}")
    public ResponseEntity<ToDoResponse> concludeToDo(@PathVariable Long id, Integer user){
        return ResponseEntity.ok(toDoService.conclude(id, user));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ToDoResponse>> listPendencies(String priorities) {
        return ResponseEntity.ok(toDoService.listPendencies(priorities));
    }

    @GetMapping("/priorities")
    public ResponseEntity<List<Priority>> priorityResponse() {
        List<Priority> priorityList = Arrays.asList(Priority.values());
        return ResponseEntity.ok(priorityList);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Status>> statusResponse() {
        List<Status> statusList = Arrays.asList(Status.values());
        return ResponseEntity.ok(statusList);
    }
}
