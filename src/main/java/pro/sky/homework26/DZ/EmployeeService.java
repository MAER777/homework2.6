package pro.sky.homework26.DZ;

public interface EmployeeService {
    String allEmployee();

    Employee addEmployee(String name, String surname) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    Employee delEmployee(String name, String surname) throws EmployeeNotFoundException;

    Employee infoEmployee(String name, String surname) throws EmployeeNotFoundException;
}
