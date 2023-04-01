package pro.sky.homework26.DZ;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int Standart = 20;
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Trapka", "Abuze")
    ));
    public String allEmployee() {
        return "Сотрудников в штате: " + employees.size();
    }

    @Override
    public Employee addEmployee(String name, String surname) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee1 = new Employee(name, surname);
        if (employees.size() >= Standart) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee1)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee1);
        return employee1;
    }

    @Override
    public Employee delEmployee(String name, String surname) throws EmployeeNotFoundException {
        int index = employees.indexOf(new Employee(name, surname));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(index);
    }

    @Override
    public Employee infoEmployee(String name, String surname) throws EmployeeNotFoundException {
        int index = employees.indexOf(new Employee(name, surname));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(index);
    }
}
