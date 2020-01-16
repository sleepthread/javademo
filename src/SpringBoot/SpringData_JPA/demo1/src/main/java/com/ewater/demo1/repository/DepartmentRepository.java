package com.ewater.demo1.repository;

import com.ewater.demo1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @className: DepartmentRepository
 * @description: TODO 类描述
 * @author: zhujun
 * @date: 2020/1/16
 **/
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
