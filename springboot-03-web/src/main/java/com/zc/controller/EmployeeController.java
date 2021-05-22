package com.zc.controller;

import com.zc.dao.DepartmentMapper;
import com.zc.dao.EmployeeMapper;
import com.zc.pojo.Department;
import com.zc.pojo.Employee;
import com.zc.service.DepartmentService;
import com.zc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping(value = "/emps")
    public String list(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping(value = "/emp")
    public String toAddPage(Model model) {
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping(value = "/emp")
    public String addEmp(Employee employee) {
        //  添加的操作

        employeeService.addEmployee(employee); //调用底层业务方法保存员工信息
        return "redirect:/emps";
    }

    //  去员工的修改页面
    @GetMapping(value = "/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("emp", employee);

        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping(value = "/updateEmp")
    public String updateEmp(Employee employee) {
        System.out.println(employee);
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping(value = "/deletemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/emps";
    }
}
