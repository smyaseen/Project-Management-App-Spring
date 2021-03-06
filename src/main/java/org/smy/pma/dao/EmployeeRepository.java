package org.smy.pma.dao;

import org.smy.pma.dto.EmployeeProject;
import org.smy.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value="Select e.first_name as firstName,e.last_name as lastName, COUNT(pe.employee_id) as projectCount " +
            "From employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
            "GROUP BY  e.first_name,e.last_name ORDER BY 3 DESC")
    List<EmployeeProject> getEmployeeProjects();

}
