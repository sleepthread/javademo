package com.ewater.demo1;

import com.ewater.demo1.entity.Department;
import com.ewater.demo1.entity.Employee;
import com.ewater.demo1.repository.DepartmentRepository;
import com.ewater.demo1.repository.EmployeeRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Optional;
import java.util.Set;

@SpringBootTest
class Demo1ApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Test
    void contextLoads() {
    }
    @Test
    public void findByIdTest() {

        Optional<Employee> optional = employeeRepository.findById("93fce66c1ef340fa866d5bd389de3d79");
        System.out.println(optional.get());
    }

    @Test
    public void findByIdTest1() {
        Optional<Department> optional = departmentRepository.findById("0a4fe7234fff42afad34f6a06a8e1821");
        Set<Employee> employees = optional.get().getEmployees();
        System.out.println(employees.size());
        //Assert.assertNotEquals(0, employees.size());
    }
}
