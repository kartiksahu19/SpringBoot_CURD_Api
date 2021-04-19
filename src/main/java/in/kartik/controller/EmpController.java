package in.kartik.controller;

import in.kartik.entity.Employee;
import in.kartik.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
      String msg = empService.addEmployee(employee);
      if(employee != null) {
          return new ResponseEntity<>(msg, HttpStatus.CREATED);
      }else {
          return new ResponseEntity<>("Record Insert" ,HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> allEmp = empService.getAllEmployee();
        return new ResponseEntity<>(allEmp, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
       String msg = empService.updateEmployee(employee);
       return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        String msg = empService.deleteEmployee(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);

    }

}
