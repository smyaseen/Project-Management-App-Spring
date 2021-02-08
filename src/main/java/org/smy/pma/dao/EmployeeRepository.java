package org.smy.pma.dao;

import org.smy.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

}
