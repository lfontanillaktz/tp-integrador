package com.kaitzen.repository;

import com.kaitzen.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByStartDateBetween(Date date1, Date date2);
    //HQL
    @Query("Select p From Project p where p.startDate between ?1 and ?2")
    List<Project> findProjectByStartDateBetweenQueryHQL(Date d1, Date d2);
    //SQL
    @Query(value="Select * From projecto where fecha_inicio between :d1 and :d2", nativeQuery = true)
    List<Project> findProjectByStartDateBetweenQuerySQL(@Param("d1") Date d1, @Param("d2") Date d2);

}
