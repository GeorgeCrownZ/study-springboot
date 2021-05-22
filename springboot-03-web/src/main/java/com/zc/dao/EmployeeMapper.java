package com.zc.dao;

import com.zc.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

//  员工Dao
@Repository
public interface EmployeeMapper {

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
