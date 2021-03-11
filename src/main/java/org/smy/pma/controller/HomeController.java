package org.smy.pma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.smy.pma.dao.EmployeeRepository;
import org.smy.pma.dao.ProjectRepository;
import org.smy.pma.dto.EmployeeProject;
import org.smy.pma.dto.ChartData;
import org.smy.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String,Object> map = new HashMap<>();

        List<Project> projects = projectRepository.findAll();
        List<EmployeeProject> employeeProjects = employeeRepository.getEmployeeProjects();
        List<ChartData> projectData = projectRepository.getProjectStatus();

        //Converting projectData object into JSON structure for use in JS
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);

        model.addAttribute("projectStatusCnt",jsonString);

        model.addAttribute("projectsList",projects);
        model.addAttribute("employeesProjects",employeeProjects);
        return "main/home";
    }

}
