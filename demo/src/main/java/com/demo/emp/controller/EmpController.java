package com.demo.emp.controller;


import com.demo.emp.entity.EmpClass;
import com.demo.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService service;



    @GetMapping("/EmployeeGet")
    public List<EmpClass> getEmployee(){
        return service.getAllEmployee();
    }

    @GetMapping("/EmployeeGet/{field}")
    public List<EmpClass> getAllEmployeeByDescendingOrder(@PathVariable String field){
        return service.getAllEmployeeByDescendingOrder(field);
    }
    @GetMapping("/EmployeeGetDescBySal")
    public List<EmpClass> getAllEmployeeByDescendingOrderBySalary(){
        return service.getAllEmployeeByDescendingOrderBySalary();
    }

    @PostMapping("/EmployeePost")
    public EmpClass saveEmployee(@RequestBody EmpClass Employee) throws Exception {
        return service.addEmployee(Employee);
    }

    @PutMapping("/EmployeePut")
    public EmpClass editEmployee(@RequestBody EmpClass Employee)
    {
        return service.editEmployee(Employee);
    }

    @PutMapping("/Employee/{id}/{salary}")
    public EmpClass updatedEmployee(@PathVariable int salary, @PathVariable int id, @RequestBody EmpClass Employee) {
        return service.updateEmployee(Employee, id);
    }
    @DeleteMapping("/EmployeeDel/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

}
