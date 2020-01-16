package com.ewater;

import static org.junit.Assert.assertTrue;

import com.ewater.mapper.UserMapper;
import com.ewater.pojo.User;
import com.ewater.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void testInsert() {
        SqlSession session = MyBatisUtil.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = new User();

            user.setName("rose");
            user.setAge(14);
            user.setEmail("lisi@qq.com");
            user.setPassword("lisi");
            userMapper.insert(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}
