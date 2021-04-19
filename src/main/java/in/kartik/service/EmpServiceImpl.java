package in.kartik.service;

import in.kartik.entity.Employee;
import in.kartik.repo.EmpRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository empRepository;

    @Override
    public String addEmployee(Employee employee) {
        empRepository.save(employee);
        return "Record Inserted Successfully";
    }
    @Override
    public List<Employee> getAllEmployee() {

        return empRepository.findAll();
    }
    @Override
    public String updateEmployee(Employee employee) {

        Optional<Employee> emp = empRepository.findById(employee.getId());
       // if (emp.isPresent())
            Employee exitEmp = emp.get();
            BeanUtils.copyProperties(employee, exitEmp);
            empRepository.save(exitEmp);
            return "Employee Details Updated";
        // else
        //    return "Employee Details Not Exit";


    }
    @Override
    public String deleteEmployee(Integer id) {
         empRepository.deleteById(id);
         return "Employee Details Deleted Successfully";
    }
}
