package in.kartik.service;

import in.kartik.entity.Employee;

import java.util.List;

public interface EmpService {

    public String addEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public String updateEmployee(Employee employee);
    public String deleteEmployee(Integer id);

}
