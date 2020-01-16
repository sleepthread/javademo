package com.ewater.demo1.entity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/**
 * @className: Role
 * @description: TODO 类描述
 * @author: zhujun
 * @date: 2020/1/16
 **/
@Entity
@Table(name = "t_role")
@Data
public class Role {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "role_name", unique = true, nullable = false, length = 64)
    private String roleName;

}
