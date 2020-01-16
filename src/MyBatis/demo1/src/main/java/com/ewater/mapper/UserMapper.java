package com.ewater.mapper;

import com.ewater.pojo.User;

/**
 * @className: UserMapper
 * @description: TODO 类描述
 * @author: zhujun
 * @date: 2020/1/15
 **/
public interface UserMapper {
    /*
       使用MyBatis的动态代理开发编写代码遵循四个原则
       1.映射文件的namespace命名空间的值必须是对应接口的全限定名。
       2.映射文件的对应功能 id值必须等于映射接口中方法的名称。
       3.映射文件的参数类型必须和接口中方法的参数类型一致。
       4.映射文件查询的返回结果类型必须和接口的方法的返回数据类型一致，
       DML操作返回的受影响的行数，除外。
    */
    void insert(User user);
}
