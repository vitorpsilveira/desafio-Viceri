package br.com.desafio.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    PENDENTE ("Pendente"),
    INICIADA ("Iniciada"),
    CANCELADA ("Cancelada"),
    AGUARDANDO ("Aguardando terceiros"),
    CONCLUIDA ("Concluida");

    private final String status;

}
