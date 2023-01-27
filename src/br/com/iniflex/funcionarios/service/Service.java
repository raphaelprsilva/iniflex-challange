package br.com.iniflex.funcionarios.service;

import br.com.iniflex.funcionarios.model.Employee;

import java.math.BigDecimal;
import java.util.*;

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
}