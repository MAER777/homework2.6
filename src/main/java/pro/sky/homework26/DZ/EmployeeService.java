package pro.sky.homework26.DZ;

public interface EmployeeService {
    String allEmployee();

    void addEmployee(Employee employee);

    void delEmployee(Employee employee);

    String infoEmployee(Integer number);
}
