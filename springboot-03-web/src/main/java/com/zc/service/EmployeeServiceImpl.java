package com.zc.service;

import com.zc.dao.EmployeeMapper;
import com.zc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public static int staticId = 1005;

    @Override
    public int addEmployee(Employee employee) {
        employee.setId(staticId++);
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public int deleteEmployee(Integer id) {
        return employeeMapper.deleteEmployee(id);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }
}
