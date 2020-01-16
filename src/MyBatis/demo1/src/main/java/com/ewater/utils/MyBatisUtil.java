package com.ewater.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @className: MyBatisUtil
 * @description: TODO 类描述
 * @author: zhujun
 * @date: 2020/1/15
 **/
public class MyBatisUtil {

    private MyBatisUtil(){}
    private  static SqlSessionFactory sqlSessionFactory;
    static {
        try (InputStream in = Resources.getResourceAsStream("mybatis-config.xml")){
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static  SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
