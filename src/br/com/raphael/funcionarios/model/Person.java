package br.com.raphael.funcionarios.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {
    private String nome;
    private LocalDate dataNascimento;

    public Person(String nome, LocalDate dataNascimento) {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(dataNascimento);

        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
