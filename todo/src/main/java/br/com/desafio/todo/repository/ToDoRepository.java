package br.com.desafio.todo.repository;

import br.com.desafio.todo.model.EToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<EToDo, Long>, JpaSpecificationExecutor<EToDo> {

    EToDo findByIdAndUserId(Long id, Integer user);

    @Query(value = "SELECT * FROM tb_todo WHERE status = :status AND priority = :priority",
            nativeQuery = true)
    List<EToDo> findByStatusAndPriority(String status, String priority);

    @Query(value = "SELECT * FROM tb_todo WHERE status = :status", nativeQuery = true)
    List<EToDo> findByStatus(String status);
}
