package pro.sky.homework26.DZ;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Trapka", "Abuze")
    ));

    public String allEmployee() {
        return "Сотрудников в штате: " + employees.size();
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i)) == true) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        if (employees.size() > employees.size()) {
            throw new EmployeeStorageIsFullException();
        }
        employees.add(employee);
    }

    @Override
    public void delEmployee(Employee employee) throws EmployeeNotFoundException {
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i))) {
                employees.remove(employee);
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String infoEmployee(Integer number) throws EmployeeNotFoundException {
        final Employee employee;
        if (number >= employees.size()) {
            throw new EmployeeNotFoundException();
        }
        employee = employees.get(number);

        final String employeeName = employee.getName() +
                " " + employee.getSurname();
        return employeeName;
    }
}
