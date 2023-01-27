package br.com.iniflex.funcionarios.service;

import br.com.iniflex.funcionarios.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Service {

    private List<Employee> employeeList;

    public Service() {

        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void setAll(List<Employee> employees) {
        employeeList.addAll(employees);
    }

    public void removeByName(String name) {
        employeeList.removeIf(employee -> employee.getName().equals(name));
    }

    public void printAll() {
        employeeList.forEach(System.out::println);
    }

    public void increaseAllSalaries(double percentage) {
        employeeList
                .forEach(employee ->
                        employee.setSalary(
                                employee.getSalary()
                                        .add(employee.getSalary().multiply(BigDecimal.valueOf(percentage))))
                );
    }

    public Map<String, List<Employee>> groupByRole() {
        Map<String, List<Employee>> groupedByRole = new HashMap<>();

        employeeList.forEach(employee -> {
            if (groupedByRole.containsKey(employee.getRole())) {
                groupedByRole.get(employee.getRole()).add(employee);
            } else {
                List<Employee> employees = new ArrayList<>();
                employees.add(employee);
                groupedByRole.put(employee.getRole(), employees);
            }
        });

        return groupedByRole;
    }

    public void printGroupedEmployees(Map<String, List<Employee>> groupedByRole) {
        groupedByRole.forEach((role, employees) -> {
            employees.forEach(System.out::println);
        });
    }

    private List<Employee> getEmployeesBirthDateBetweenMonths(int month1, int month2) {
        List<Employee> employees = new ArrayList<>();
        employeeList.forEach(employee -> {
            boolean isEmployeeMonthValueGreaterThan = employee.getBirthDate().getMonthValue() >= month1;
            boolean isEmployeeMonthValueLowerThan = employee.getBirthDate().getMonthValue() <= month2;
            boolean isBirthDatesBetweenMonth1AndMonth2 = isEmployeeMonthValueGreaterThan && isEmployeeMonthValueLowerThan;

            if (isBirthDatesBetweenMonth1AndMonth2) {
                employees.add(employee);
            }
        });
        return employees;
    }

    public void printEmployeesBirthDateBetweenMonths(int month1, int month2) {
        System.out.printf("Funcionários nascidos entre os meses %d e %d:%n", month1, month2);
        getEmployeesBirthDateBetweenMonths(month1, month2).forEach(System.out::println);
    }

    private Employee getOldestEmployee() {
        return employeeList.stream()
                .min(Comparator.comparing(Employee::getBirthDate))
                .orElseThrow(NoSuchElementException::new);
    }

    public void printOldestEmployee() {
        System.out.println("Funcionário mais velho:");

        String employeeName = getOldestEmployee().getName();
        System.out.printf("Nome: %s%n", employeeName);

        Integer currentYear = LocalDate.now().getYear();
        Integer employeeBirthDate = getOldestEmployee().getBirthDate().getYear();
        Integer employeeAge = currentYear - employeeBirthDate;
        System.out.printf("Idade: %s%n", employeeAge);
    }

    private List<Employee> getEmployeesByAlphabeticalOrder() {
        return employeeList.stream()
            .sorted(Comparator.comparing(Employee::getName))
            .collect(Collectors.toList());
    }

    public void printEmployeesByAlphabeticalOrder() {
        System.out.println("Funcionários em ordem alfabética:");
        getEmployeesByAlphabeticalOrder().forEach(System.out::println);
    }

    private BigDecimal sumAllSalaries() {
        return employeeList.stream()
            .map(Employee::getSalary)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void printSumAllSalaries() {
        System.out.println("Soma de todos os salários:");
        BigDecimal allSalariesSummed = sumAllSalaries();
        System.out.printf("R$ %.2f%n", allSalariesSummed);
    }
}