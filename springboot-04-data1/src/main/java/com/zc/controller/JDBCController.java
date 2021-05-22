package com.zc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/userList")
    //  查询数据的所有信息
    public List<Map<String, Object>> userList() {
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping(value = "/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user (id, name, password) values (8, '小明', 'xm888888')";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    @GetMapping(value = "/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "update mybatis.user set name=?, password=? where id = " + id;

        //  封装
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "zzzzzzzz";

        jdbcTemplate.update(sql, objects);
        return "update-ok";
    }

    @GetMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        String sql = "delete from mybatis.user where id = ?";
        jdbcTemplate.update(sql, id);
        return "delete-ok";
    }


}
