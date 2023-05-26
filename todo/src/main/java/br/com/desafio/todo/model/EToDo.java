package br.com.desafio.todo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_todo")
public class EToDo {

    @Id
    @GeneratedValue(generator = "todo_seq_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "todo_seq_generator", sequenceName = "todo_seq", allocationSize = 1)
    private Long id;

    private String toDo;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private EUser user;

}
