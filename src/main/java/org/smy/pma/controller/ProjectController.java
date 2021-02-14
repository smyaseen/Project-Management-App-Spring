package org.smy.pma.controller;

import org.smy.pma.dao.EmployeeRepository;
import org.smy.pma.dao.ProjectRepository;
import org.smy.pma.entities.Employee;
import org.smy.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projectsList",projects);
        return "projects/list-projects";
    }


    @GetMapping("/new-project")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("allEmployees",employees);
          return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project,@RequestParam List<Long> employees, Model model) {
        //save to database
        projectRepository.save(project);

        return "redirect:/projects/new-project";
    }


}
