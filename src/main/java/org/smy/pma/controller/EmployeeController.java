package org.smy.pma.controller;
import org.smy.pma.dao.EmployeeRepository;
import org.smy.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees",employees);
        return "employees/list-employees";
    }

    @GetMapping("/new-employee")
    public String displayEmployeeForm(Model model) {
        Employee aEmployee = new Employee();
        model.addAttribute("employee",aEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        employeeRepository.save(employee);
        return "redirect:/employees/new-employee";
    }

}
