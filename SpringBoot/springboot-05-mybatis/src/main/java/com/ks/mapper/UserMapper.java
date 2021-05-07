package com.ks.mapper;

import com.ks.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper // 这个注解表示了这是一个mybatis的一个mapper类， Dao
@Repository // 将Dao层的类，声明为bean
public interface UserMapper { // 1.绑定mapper.xml，2.用于控制层调用

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
