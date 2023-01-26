package br.com.iniflex.funcionarios.service;

import br.com.iniflex.funcionarios.model.Employee;

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

}