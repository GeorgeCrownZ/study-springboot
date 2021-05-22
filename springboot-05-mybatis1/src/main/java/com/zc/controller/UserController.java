package com.zc.controller;

import com.zc.mapper.UserMapper;
import com.zc.pojo.User;
import com.zc.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping(value = "/queryList")
    public List<User> queryList() {
        return userMapper.queryUserList();
    }

    @GetMapping(value = "/queryUserById/{id}")
    public User queryUserById(@PathVariable("id") Integer id) {
        return userMapper.queryUserById(id);
    }

    @GetMapping(value = "/updateUser")
    public String updateUser() {
        User user = new User(6,"小明","123963");
        userMapper.updateUser(user);
        return "update success";
    }

    @GetMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")Integer id) {
        userMapper.deleteUser(id);
        return "delete success";
    }

    @GetMapping(value = "/addUser")
    public String addUser() {
        User user = new User(UUIDUtils.getID(),"小王八","wwwbbb");
        userMapper.addUser(user);
        return "insert success";
    }

}
