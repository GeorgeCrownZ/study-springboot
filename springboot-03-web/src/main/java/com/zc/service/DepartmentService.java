package com.zc.service;

import com.zc.pojo.Department;

import java.util.List;

public interface DepartmentService {

    //  获得所有部门信息
    public List<Department> getDepartments();

    //  通过id得到部门
    public Department getDepartmentById(Integer id);

}
