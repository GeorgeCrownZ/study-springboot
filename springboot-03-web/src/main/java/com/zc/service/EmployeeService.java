package com.zc.service;

import com.zc.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    //  增加一个员工
    public int addEmployee(Employee employee);

    //  查询全部员工
    public List<Employee> getAllEmployee();

    //  通过id查询员工
    public Employee getEmployeeById(Integer id);

    //  删除员工
    public int deleteEmployee(Integer id);

    //  修改员工
    public int updateEmployee(Employee employee);
}
