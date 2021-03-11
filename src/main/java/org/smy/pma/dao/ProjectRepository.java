package org.smy.pma.dao;

import org.smy.pma.dto.ChartData;
import org.smy.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as label, Count(*) as value FROM project GROUP BY stage")
    List<ChartData> getProjectStatus();
}
