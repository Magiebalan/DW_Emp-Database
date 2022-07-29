package com.demo.emp.service;


import com.demo.emp.controller.ErrorMessages;
import com.demo.emp.entity.EmpClass;
import com.demo.emp.repository.EmpRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository repository;

    // to add the Employee
    public EmpClass addEmployee(@NotNull EmpClass Employee) throws Exception {
        EmpClass addEmployee = repository.findById(Employee.getId());

        if(addEmployee != null){
            throw new empServiceException
                    (ErrorMessages.Employee_already_exists_in_the_database.getErrorMessages());
        }
           return repository.save(Employee);
    }



    // to get all the Employee
    public List<EmpClass> getAllEmployee() {
        return repository.findAll();
    }

    // to get the element based on Descending order
    public List<EmpClass> getAllEmployeeByDescendingOrder(String field) {
        return repository.findAll(Sort.by(Sort.Direction.DESC,field));
    }
   public List<EmpClass> getAllEmployeeByDescendingOrderBySalary(){
       List<EmpClass> list = repository.findAll();
       list.sort(new Comparator<EmpClass>() {
           @Override
           public int compare(EmpClass o1, EmpClass o2) {
               if(o2.getSalary()==o1.getSalary()){
                   return o1.getName().compareTo(o2.getName());
               }
               return o2.getSalary()-o1.getSalary();
           }
       });
       return list;
   }

    // to edit the Employee
    public EmpClass editEmployee(EmpClass Employee) {
        EmpClass ExistingEmployee;
        ExistingEmployee = repository.findById(Employee.getId());
        ExistingEmployee.setSalary(Employee.getSalary());
        ExistingEmployee.setName(Employee.getName());
        ExistingEmployee.setDesignation(Employee.getDesignation());
         return repository.save(ExistingEmployee);
    }
    public EmpClass updateEmployee(EmpClass Employee, int id)
    {
        EmpClass empupdate;
        empupdate = repository.findById(Employee.getId());
        empupdate.setName(Employee.getName());
        empupdate.setSalary(Employee.getSalary());
        empupdate.setDesignation(Employee.getDesignation());
        repository.save(empupdate);
        return empupdate;
    }

    // to delete the Employee
    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee deleted";
    }


}

