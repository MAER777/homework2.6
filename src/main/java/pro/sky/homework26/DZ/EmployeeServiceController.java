package pro.sky.homework26.DZ;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeServiceController {
    private final EmployeeService employeeService;

    public EmployeeServiceController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public String allEmployee() {
        return employeeService.allEmployee();
    }

    @GetMapping(path = "add")
    public Employee addEmployee(@RequestParam ("name") String name,
                                @RequestParam ("surname") String surname) {
        return employeeService.addEmployee(name, surname);
//        try {
//            Employee employee = new Employee(name, surname);
//            employeeService.addEmployee(employee);
//            return name + " " + surname + " добавлен(а)";
//        } catch (EmployeeAlreadyAddedException e) {
//            return "Такой сотрудник уже добавлен";
//        } catch (EmployeeStorageIsFullException e) {
//            return "База сотрудников переполнена";
//        }
//        Employee employee = new Employee(name, surname);
//        employeeService.addEmployee(employee);
//        return name + " " + surname + " добавлен(а)";
    }
    @GetMapping(path = "del")
    public Employee dellEmployee(@RequestParam ("name") String name,
                                 @RequestParam ("surname") String surname) {
        return employeeService.delEmployee(name, surname);
//        try {
//            Employee employee = new Employee(name, surname);
//            employeeService.delEmployee(employee);
//            return name + " " + surname + " удален(а)";
//        } catch (EmployeeNotFoundException e) {
//            return "Сотрудник не найден";
//        }
//        Employee employee = new Employee(name, surname);
//        employeeService.delEmployee(employee);
//        return name + " " + surname + " удален(а)";
    }

    @GetMapping(path = "info")
    public Employee infoEmployee(@RequestParam ("name") String name, @RequestParam ("surname") String surname) {
        return employeeService.infoEmployee(name, surname);
//        try {
//            return employeeService.infoEmployee(number);
//        } catch (EmployeeNotFoundException e) {
//            return "Сотрудника с таким номером нет";
//        }
//        final String employee;
//        employee = employeeService.infoEmployee(number);
//        return employee;
    }
}
