package br.com.desafio.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tb_user")
public class EUser {

    @Id
//    @GeneratedValue(generator = "user_seq_generator", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "user_seq_generator", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String name;

    private String email;

    @Column(name = "user_password")
    private String password;


}
