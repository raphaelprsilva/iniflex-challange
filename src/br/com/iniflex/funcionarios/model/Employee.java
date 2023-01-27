package br.com.iniflex.funcionarios.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public static String formatDate(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(dateTimeFormatter);
    }

    static String formatSalary(BigDecimal salary) {
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
        return decimalFormat.format(salary);
    }

    @Override
    public String toString() {
        return String.format("Pessoa Funcionária: %s%n" +
                        "Data de Nascimento: %s%n" +
                        "Salário: %s%n" +
                        "Função: %s%n",
                this.getName(),
                Employee.formatDate(this.getBirthDate()),
                Employee.formatSalary(this.getSalary()),
                this.getRole()
        );
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
