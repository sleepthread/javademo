package com.ewater.demo1.repository;

import com.ewater.demo1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @className: EmployeeRepository
 * @description: TODO 类描述
 * @author: zhujun
 * @date: 2020/1/16
 **/
public interface EmployeeRepository  extends JpaRepository<Employee, String> {
}
