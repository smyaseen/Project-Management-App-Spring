package org.smy.pma.dao;

import org.smy.pma.entities.Employee;
import org.smy.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();

}
