package com.zc.mapper;

import com.zc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//  这个注解表示了这是一个mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(Integer id);

    int updateUser(User user);

    int deleteUser(Integer id);

    int addUser(User user);
}
