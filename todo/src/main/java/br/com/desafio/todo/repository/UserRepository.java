package br.com.desafio.todo.repository;

import br.com.desafio.todo.model.EUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<EUser, Integer> {

    public Optional<EUser> findByEmail(String email);

}
