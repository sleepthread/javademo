package com.ewater.demo1.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;
/**
 * @className: Employee
 * @description: TODO 类描述
 * @author: zhujun
 * @date: 2020/1/16
 **/


@Entity
@Table(name = "t_emp")
//@Data
@Setter
@Getter
//@EqualsAndHashCode
public class Employee {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "emp_name", nullable = false, length = 64)
    private String empName;

    @Column(name = "emp_job", length = 64)
    private String empJob;

    @Column(name = "dept_id", insertable = false, updatable = false)
    private String deptId;

    @ManyToOne(targetEntity = Department.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", empName='" + empName + '\'' +
                ", empJob='" + empJob + '\'' +
                ", deptId='" + deptId + '\'' +

                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(empName, employee.empName) &&
                Objects.equals(empJob, employee.empJob) &&
                Objects.equals(deptId, employee.deptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empName, empJob, deptId);
    }
}