package br.com.desafio.todo.controller;

import br.com.desafio.todo.model.EUser;
import br.com.desafio.todo.model.request.UserRequest;
import br.com.desafio.todo.model.response.UserResponse;
import br.com.desafio.todo.repository.UserRepository;
import br.com.desafio.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/api/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @PostMapping("/save")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha (@RequestParam String email, @RequestParam String password) {

        Optional<EUser> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        EUser user = userOptional.get();
        boolean valid = encoder.matches(password, user.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(valid);
    }
}
