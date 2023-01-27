import br.com.iniflex.funcionarios.model.Employee;
import br.com.iniflex.funcionarios.service.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service employeesService = new Service();

        List<Employee> employees = getEmployees();
        employeesService.setAll(employees);

        try {
            do {
                switch (Menu.show()) {
                    case 1 -> employeesService.printAll();
                    case 2 -> employeesService.removeByName("João");
                    case 3 -> employeesService.increaseAllSalaries(0.1);
                    case 4 -> employeesService.printGroupedEmployees(employeesService.groupByRole());
                    case 5 -> employeesService.printEmployeesBirthDateBetweenMonths(10, 12);
                    case 6 -> employeesService.printOldestEmployee();
                    case 7 -> employeesService.printEmployeesByAlphabeticalOrder();
                    case 8 -> employeesService.printSumAllSalaries();
                    case 9 -> employeesService.printSalariesByEmployee();
                    case 10 -> System.exit(0);
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
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

    private static class Menu {
        public static int show() {
            System.out.println("1 - Listar todos os funcionários");
            System.out.println("2 - Remover funcionário \"João\"");
            System.out.println("3 - Aumentar salário de todos os funcionários em 10%");
            System.out.println("4 - Agrupar funcionários por cargo");
            System.out.println("5 - Listar funcionários que nasceram entre os meses de outubro e dezembro");
            System.out.println("6 - Listar o funcionário mais velho");
            System.out.println("7 - Listar funcionários em ordem alfabética");
            System.out.println("8 - Somar todos os salários");
            System.out.println("9 - Listar salários por funcionário");
            System.out.println("10 - Sair");
            System.out.print("Opção: ");
            return new Scanner(System.in).nextInt();
        }
    }


}