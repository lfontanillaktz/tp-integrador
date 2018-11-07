package com.kaitzen.repository;

import com.kaitzen.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> findAllByName(String name);

    @Query("select p from Project p where p.startDate between ?1 and ?2")
    List<Project> findByStartDateBetweenHQL(Date fecha1, Date fecha2);
    //List<Project> findByStartDateBetween(Date fecha1, Date fecha2);


}
