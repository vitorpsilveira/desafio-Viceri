package br.com.desafio.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {

    ALTA("Alta"),
    MEDIA("Média"),
    BAIXA("Baixa");

    private final String priority;

}
