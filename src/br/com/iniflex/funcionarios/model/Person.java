package br.com.iniflex.funcionarios.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {
    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(birthDate);

        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
