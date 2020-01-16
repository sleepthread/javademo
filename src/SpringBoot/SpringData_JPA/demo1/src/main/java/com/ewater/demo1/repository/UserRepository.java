package com.ewater.demo1.repository;

import com.ewater.demo1.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @className: UserRepository
 * @description: TODO 类描述
 * @author: zhujun
 * @date: 2020/1/16
 **/
public interface UserRepository  extends JpaRepository<User, String> {
    /*
    * Spring Data Jpa通过解析方法名创建查询，框架在进行方法名解析时，
    * 会先把方法名多余的前缀find…By, read…By, query…By, count…By以及get…By截取掉，
    * 然后对剩下部分进行解析，第一个By会被用作分隔符来指示实际查询条件的开始。
    * 我们可以在实体属性上定义条件，并将它们与And和Or连接起来，从而创建大量查询：
    * 具体Spring Data Jpa对方法名的解析规则可参看官方文档4.4.3. Property Expressions
    * url:https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-property-expressions
    * */

    List<User> findByUsername(String username);

    //自定义查询Using @Query
    @Query("select u from User  u where u.email = ?1")
    User getByEmail(String eamil);

    @Query("select u from User u where u.username = :username or u.email = :email")
    User getByUsernameOrEmail(@Param("username") String username, @Param("email") String email);

    /*
    *  entityName的解析方式如下：如果实体类在@Entity注解上设置了name属性，则使用它。 否则，使用实体类的简单类名。为避免在@Query注解使用实际的实体类名，就可以使用#{#entityName}进行代替。如以上示例中，@Query注解的查询字符串里的User都可替换为#{#entityName}
    * */

    @Query("select u from #{#entityName} u where u.email = ?1")
    User getByEmail2(String eamil);

    /*
    *@Query注解还支持通过将nativeQuery标志设置为true来执行原生查询，同样支持基于位置的参数绑定及命名参数
    * */

    @Query(value = "select * from tb_user u where u.email = ?1", nativeQuery = true)
    User queryByEmail(String email);

    /*
    * Spring Data Jpa可以在方法参数中直接传入Pageable或Sort来完成动态分页或排序，通常Pageable或Sort会是方法的最后一个参数，如：
    * */

    @Query("select u from User u where u.username like %?1%")
    Page<User> findByUsernameLike(String username, Pageable pageable);
    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameAndSort(String username, Sort sort);

    /*
    注意：Spring Data Jpa目前不支持对原生查询进行动态排序，但可以通过自己指定计数查询countQuery来使用原生查询进行分页、排序，如：
    * */
    @Query(value = "select * from tb_user u where u.username like %?1%",
            countQuery = "select count(1) from tb_user u where u.username = %?1%",
            nativeQuery = true)
    Page<User> queryByUsernameLike(String username, Pageable pageable);


    /*
    单独使用@Query注解只是查询，如涉及到修改、删除则需要再加上@Modifying注解，如：
    * */

    @Transactional()
    @Modifying
    @Query("update User u set u.password = ?2 where u.username = ?1")
    int updatePasswordByUsername(String username, String password);

    @Transactional()
    @Modifying
    @Query("delete from User where username = ?1")
    void deleteByUsername(String username);



}
