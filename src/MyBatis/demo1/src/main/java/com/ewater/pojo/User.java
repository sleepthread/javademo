package com.ewater.pojo;

import lombok.Data;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: zhujun
 * @date: 2020/1/15
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String password;
}
