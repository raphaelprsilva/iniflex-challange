package br.com.raphael.funcionarios.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person {
    private BigDecimal salary;
    private String role;

    public Employee(String name, LocalDate birthDate, BigDecimal salary, String role) {
        super(name, birthDate);

        Objects.requireNonNull(salary);
        Objects.requireNonNull(role);

        this.salary = salary;
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salario=" + salary +
                ", funcao='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(salary, employee.salary) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, role);
    }
}
