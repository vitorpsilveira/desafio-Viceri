package br.com.desafio.todo.service;

import br.com.desafio.todo.mapper.UserMapper;
import br.com.desafio.todo.model.EUser;
import br.com.desafio.todo.model.request.UserRequest;
import br.com.desafio.todo.model.response.UserResponse;
import br.com.desafio.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public UserResponse save(UserRequest newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword()));

        EUser eUser = userMapper.userRequestToEUser(newUser);

        UserResponse response = userMapper.eUsertoUserResponse(userRepository.save(eUser));

        return response;
    }

    public EUser findById(Integer id) {
        return userRepository.findById(id).get();
    }
}
