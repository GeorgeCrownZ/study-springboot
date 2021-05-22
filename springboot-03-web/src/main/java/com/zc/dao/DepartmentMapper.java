package com.zc.dao;

import com.zc.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {

    //  获得所有部门信息
    public List<Department> getDepartments();

    //  通过id得到部门
    public Department getDepartmentById(Integer id);
}
