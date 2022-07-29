package com.demo.emp.repository;

import com.demo.emp.entity.EmpClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<EmpClass, Integer> {

    EmpClass findById(int id);

}
