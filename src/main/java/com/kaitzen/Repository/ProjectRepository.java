package com.kaitzen.Repository;

import com.kaitzen.Modelos.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> findByStartDateBetween(Date date1, Date date2);
}
