package org.smy.pma.controller;

import org.smy.pma.dao.EmployeeRepository;
import org.smy.pma.dao.ProjectRepository;
import org.smy.pma.entities.Employee;
import org.smy.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = projectRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("projectsList",projects);
        model.addAttribute("employeesList",employees);
        return "main/home";
    }

}
