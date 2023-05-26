package br.com.desafio.todo.mapper;

import br.com.desafio.todo.model.EUser;
import br.com.desafio.todo.model.request.UserRequest;
import br.com.desafio.todo.model.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    default EUser userRequestToEUser(UserRequest request){
        return EUser.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    };

    default UserResponse eUsertoUserResponse(EUser user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    };
}
