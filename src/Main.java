import br.com.iniflex.funcionarios.model.Employee;
import br.com.iniflex.funcionarios.service.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service employeesService = new Service();

        List<Employee> employees = getEmployees();

        try {
            employeesService.setAll(employees);
            employeesService.removeByName("João");
            employeesService.printAll();
            employeesService.increaseAllSalaries(0.1);
            var groupedEmployees = employeesService.groupByRole();
            employeesService.printGroupedEmployees(groupedEmployees);
            employeesService.printEmployeesBirthDateBetweenMonths(10, 12);
        } catch (Exception e) {
            System.out.println("ParseException: " + e.getMessage());
        }
    }

    private static List<Employee> getEmployees() {
        return List.of(
            new Employee("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"),
            new Employee("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador"),
            new Employee("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador"),
            new Employee("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"),
            new Employee("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista"),
            new Employee("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"),
            new Employee("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador"),
            new Employee("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente"),
            new Employee("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista"),
            new Employee("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente")
        );
    }


}