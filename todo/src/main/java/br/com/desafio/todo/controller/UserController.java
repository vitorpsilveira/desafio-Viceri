package br.com.desafio.todo.controller;

import br.com.desafio.todo.model.EUser;
import br.com.desafio.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/api/todo/user")
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/save")
    public ResponseEntity<EUser> save(@RequestBody EUser user) {
        return ResponseEntity.ok(userRepository.save(user));
    }
}
